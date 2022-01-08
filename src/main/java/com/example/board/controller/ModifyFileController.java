package com.example.board.controller;

import com.example.board.model.BoardVo;
import com.example.board.model.MapVoForApi;
import com.example.board.model.PostVo;
import com.example.board.model.ReviewVo;
import com.example.board.service.FileUploadService;
import com.example.board.service.MapServiceForApi;
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
public class ModifyFileController {
    @Autowired
    private PostService postService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private MapServiceForApi mapServiceForApi;

    @RequestMapping(value = "/uploadFileForModify", method = RequestMethod.POST)
    public String modifyFiles(HttpServletRequest request, @RequestParam(value = "images", required = false) List<MultipartFile> images,
                              @RequestParam(value = "postNo", required = false) int postNo,
                              @RequestParam(value = "videos", required = false) List<MultipartFile> videos,
                              @RequestParam(value = "bordNo", required = false, defaultValue = "1") Integer boardNo,
                              @RequestParam(value = "subject", required = false) String subject,
                              @RequestParam(value = "content", required = false) String content,
                              @RequestParam(value = "tag", required = false) String tag,
                              @RequestParam(value = "address_name", required = false) String address_name,
                              @RequestParam(value = "category_group_code", required = false, defaultValue = "noValue") String category_group_code,
                              @RequestParam(value = "category_group_name", required = false, defaultValue = "noValue") String category_group_name,
                              @RequestParam(value = "category_name", required = false, defaultValue = "noValue") String category_name,
                              @RequestParam(value = "distance", required = false, defaultValue = "noValue") String distance,
                              @RequestParam(value = "id", required = false, defaultValue = "noValue") String id,
                              @RequestParam(value = "phone", required = false, defaultValue = "noValue") String phone,
                              @RequestParam(value = "place_name", required = false, defaultValue = "noValue") String place_name,
                              @RequestParam(value = "place_url", required = false, defaultValue = "noValue") String place_url,
                              @RequestParam(value = "road_address_name", required = false, defaultValue = "noValue") String road_address_name,
                              @RequestParam(value = "x", required = false, defaultValue = "noValue") String x,
                              @RequestParam(value = "y", required = false, defaultValue = "noValue") String y,
                              @RequestParam(value = "map_no", required = false, defaultValue = "0") Integer map_no,
                              @RequestParam(value = "rateLoc", required = false) Integer rateLoc,
                              @RequestParam(value = "rateClean", required = false) Integer rateClean,
                              @RequestParam(value = "rateComu", required = false) Integer rateComu,
                              @RequestParam(value = "rateChip", required = false) Integer rateChip,
                              @RequestParam(value = "visitDate", required = false) String visitDate,
                              @RequestParam(value = "recommendPlace", required = false) String recommendPlace,
                              @RequestParam(value = "notRecommendPerson", required = false) String notRecommendPerson){
        int writerNo = 1;
        HttpSession session = request.getSession();
        try {
            MemberVo memberVo = (MemberVo) session.getAttribute("member");
            writerNo = memberVo.getMemNo();
        } catch (Exception e) {

        }

        // 게시글
        String newContent = convert(content);
        PostVo postVo = new PostVo();
        postVo.setPostNo(postNo);
        postVo.setSubject(subject);
        postVo.setContent(newContent);
        postVo.setTag(tag);

        this.postService.modifyPost(postVo);
        System.out.println("숙소 정보 : " + address_name);

        // 숙소 정보, 리뷰 정보
        BoardVo boardForUseCheck = this.postService.retrieveBoardForUseCheck(boardNo);
        if(boardForUseCheck.getType().equals("basic")){

        } else {
            if (address_name.trim().equals("") || map_no == 0) {

            } else{
                MapVoForApi mapVoForApi = new MapVoForApi();
                mapVoForApi.setAddress_name(address_name);
                mapVoForApi.setCategory_group_code(category_group_code);
                mapVoForApi.setCategory_group_name(category_group_name);
                mapVoForApi.setCategory_name(category_name);
                mapVoForApi.setDistance(distance);
                mapVoForApi.setId(id);
                mapVoForApi.setPhone(phone);
                mapVoForApi.setPlace_name(place_name);
                mapVoForApi.setPlace_url(place_url);
                mapVoForApi.setRoad_address_name(road_address_name);
                mapVoForApi.setX(x);
                mapVoForApi.setY(y);
                mapVoForApi.setMap_no(map_no);

                this.mapServiceForApi.modifyMap(mapVoForApi);

                ReviewVo review = new ReviewVo();

                if(visitDate.trim().equals("")){
                    visitDate = null;
                }

                review.setPostNo(postNo);
                review.setRateLoc(rateLoc);
                review.setRateClean(rateClean);
                review.setRateComu(rateComu);
                review.setRateChip(rateChip);
                review.setVisitDate(visitDate);
                review.setRecommendPlace(recommendPlace);
                review.setNotRecommendPerson(notRecommendPerson);
                this.reviewService.modifyReview(review);
            }
        }




        // 파일
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
