package com.example.board.service;

import com.example.board.model.AttachVo;
import com.example.board.persistent.AttachDao;
import com.example.common.MediaUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

@Service
public class FileUploadService {
    @Value("${resources.uri_path:}")
    private String resourcesUriPath;

    @Autowired
    private AttachDao attachDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public String restore(MultipartFile multipartFile, int postNo, int fileType) throws Exception {
        String originalName = multipartFile.getOriginalFilename();
        // 중복된 이름의 파일을 저장하지 않기 위해 UUID 키값 생성
        UUID uuid = UUID.randomUUID();
        // 실제 저장할 파일명 = UUID + _ + 원본파일명
        String savedName = uuid.toString() + "_" + originalName;
        // 서버에서 저장 할 파일 이름
        String systemFileName = getSaveFileName(savedName);
        // 파일 사이즈
        int fileSize = ((Long) multipartFile.getSize()).intValue();
        //파일 객체 생성
        AttachVo attach = new AttachVo(postNo, originalName, systemFileName, fileSize, fileType);
        // file저장
        writeFile(multipartFile, systemFileName);
        // 파일 확장자 추출
        String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
        // 확장자에 따라 썸네일 이미지 생성 or 일반 파일 아이콘 생성
        if (MediaUtils.getMediaType(formatName) != null) {
            // 썸네일 이미지 생성, 썸네일 이미지 파일명
            makeThumbnail(resourcesUriPath, "/", systemFileName);
        }
        //db에 파일 추가
        attachDao.insertPostAttach(attach);
        // 업로드 파일명 반환
        return systemFileName;
    }

    // 2. 현재 시간을 기준으로 파일 이름 생성
    private String getSaveFileName(String extName) {
        String fileName = "";

        Calendar calendar = Calendar.getInstance();
        fileName += calendar.get(Calendar.YEAR);
        fileName += calendar.get(Calendar.MONTH);
        fileName += calendar.get(Calendar.DATE);
        fileName += calendar.get(Calendar.HOUR);
        fileName += calendar.get(Calendar.MINUTE);
        fileName += calendar.get(Calendar.SECOND);
        fileName += calendar.get(Calendar.MILLISECOND);
        fileName += extName;

        return fileName;
    }

    // 3. 파일을 실제로 write 하는 메서드
    private boolean writeFile(MultipartFile multipartFile, String systemFileName) throws IOException {
        boolean result = false;
        byte[] data = multipartFile.getBytes();
        FileOutputStream fos = new FileOutputStream(resourcesUriPath + "/" + systemFileName);
        fos.write(data);
        fos.close();

        return result;
    }

    // 4. 썸네일 생성 : 이미지 파일의 경우
    private String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
        //BufferedImage : 실제 이미지 X, 메모리상의 이미지를 의미하는 객체
        // 원본 이미지파일을 메모리에 로딩
        BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));

        // 1번째 방법. 정해진 크기에 맞게 원본이미지를 축소
        //BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);

        // 2번째 방법. 계산된 크기로 원본이미지를 가운데에서 crop 합니다.
        // 썸네일의 너비와 높이 입니다.
        int dw = 250, dh = 250;
        // 원본 이미지의 너비와 높이 입니다.
        int ow = sourceImg.getWidth();
        int oh = sourceImg.getHeight();
        // 원본 너비를 기준으로 하여 썸네일의 비율로 높이를 계산합니다.
        int nw = ow;
        int nh = (ow * dh) / dw;
        // 계산된 높이가 원본보다 높다면 crop이 안되므로
        // 원본 높이를 기준으로 썸네일의 비율로 너비를 계산합니다.
        if (nh > oh) {
            nw = (oh * dw) / dh;
            nh = oh;
        }
        BufferedImage cropImg = Scalr.crop(sourceImg, (ow - nw) / 2, (oh - nh) / 2, nw, nh);

        // crop된 이미지로 썸네일을 생성합니다.
        BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
        // 썸네일 이미지 파일명
        String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
        // 썸네일 이미지 파일 객체 생성
        File newFile = new File(thumbnailName);
        // 파일 확장자 추출
        String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 썸네일 파일 저장
        ImageIO.write(destImg, formatName.toUpperCase(), newFile);
        return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
    }
}
