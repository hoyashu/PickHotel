package com.example.board.controller;

import com.example.board.model.PostVo;
import com.example.board.model.ReviewVo;
import com.example.board.service.FileUploadService;
import com.example.board.service.PostService;
import com.example.board.service.ReviewService;
import com.example.member.model.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FileController {
    @Autowired
    private PostService postService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private FileUploadService fileUploadService;

    //게시글 작성
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String registerFiles(HttpServletRequest request, @RequestParam(value = "images", required = false) List<MultipartFile> images,
                                @RequestParam(value = "videos", required = false) List<MultipartFile> videos,
                                @RequestParam(value = "bordNo", required = false, defaultValue = "1") int boardNo,
                                @RequestParam(value = "subject", required = false) String subject,
                                @RequestParam(value = "content", required = false) String content,
                                @RequestParam(value = "tag", required = false) String tag,
                                @RequestParam(value = "roomNo", required = false, defaultValue = "-1") int roomNo,
                                @RequestParam(value = "rateLoc", required = false) int rateLoc,
                                @RequestParam(value = "rateClean", required = false) int rateClean,
                                @RequestParam(value = "rateComu", required = false) int rateComu,
                                @RequestParam(value = "rateChip", required = false) int rateChip,
                                @RequestParam(value = "visitDate", required = false) String visitDate,
                                @RequestParam(value = "recommendPlace", required = false) String recommendPlace,
                                @RequestParam(value = "notRecommendPerson", required = false) String notRecommendPerson) {
        HttpSession session = request.getSession();
        MemberVo memberVo = (MemberVo) session.getAttribute("member");
        int writerNo = memberVo.getMemNo();

        String newContent = convert(content);
        PostVo postVo = new PostVo();
        postVo.setWriterNo(writerNo);
        postVo.setBoardNo(boardNo);
        postVo.setSubject(subject);
        postVo.setContent(newContent);
        postVo.setTag(tag);

        int postNo = postService.registerPost(postVo);
        session.setAttribute("boardNo", boardNo);

        if (roomNo != -1) {
            ReviewVo review = new ReviewVo();
            review.setRoomNo(roomNo);
            review.setRateLoc(rateLoc);
            review.setRateClean(rateClean);
            review.setRateComu(rateComu);
            review.setRateChip(rateChip);
            review.setVisitDate(visitDate);
            review.setRecommendPlace(recommendPlace);
            review.setNotRecommendPerson(notRecommendPerson);
            this.reviewService.registerReview(review);
        }

        if (images != null) {
            System.out.println("images");

            for (MultipartFile file : images) {
                String fileName = null;
                if (!file.getOriginalFilename().isEmpty()) {
                    fileName = fileUploadService.restore(file, postNo, 1);
                } else {
                    fileName = "default.jpg";
                }

            }
        }
        if (videos != null) {
            System.out.println("videos");

            for (MultipartFile file : videos) {
                String fileName = null;
                if (!file.getOriginalFilename().isEmpty()) {
                    fileName = fileUploadService.restore(file, postNo, 2);
                } else {
                    fileName = "default.mp4";
                }
            }
        }

        return "redirect:/post/" + postVo.getPostNo();
    }

    private String convert(String oldStr) {
        String newStr = oldStr.replace("'", "''");
        newStr = newStr.replace("<", "&lt;");
        newStr = newStr.replace(">", "&gt;");
        newStr = newStr.replace("\n", "<br />");
        return newStr;
    }
}

















