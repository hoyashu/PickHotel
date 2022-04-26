package com.example.board.controller;

import com.example.board.model.BoardVo;
import com.example.board.model.MapVoForApi;
import com.example.board.model.PostVo;
import com.example.board.model.ReviewVo;
import com.example.board.service.*;
import com.example.member.model.MemberVo;
import com.example.member.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional
@Controller
public class ModifyFileController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private PostService postService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private MapServiceForApi mapServiceForApi;

    @RequestMapping(value = "/member/uploadFileForModify", method = RequestMethod.POST)
    public String modifyFiles(HttpServletRequest request,
                              PostVo post, ReviewVo getReview, MapVoForApi map,
                              @RequestParam(value = "images", required = false) List<MultipartFile> images,
                              @RequestParam(value = "videos", required = false) List<MultipartFile> videos,
                              @AuthenticationPrincipal UserAccount userAccount) throws Exception {
        HttpSession session = request.getSession();

        // 세션가져올 준비
        MemberVo member = userAccount.getMember();
        int memNo = member.getMemNo();

        // 게시글
        String newContent = post.getContent();
        PostVo postVo = new PostVo();
        postVo.setWriterNo(memNo);
        postVo.setBoardNo(post.getBoardNo());
        postVo.setSubject(post.getSubject());
        postVo.setContent(newContent);
        postVo.setTag(post.getTag());

        int postNo = postService.addPost(postVo);
        session.setAttribute("boardNo", post.getBoardNo());

        BoardVo board = this.boardService.retrieveBoard(post.getBoardNo());
        if (board.getType().equals("basic")) {

        } else {
            // 숙소 정보, 리뷰 정보
            if (map.getAddressName().trim().equals("")) {

            } else {
                MapVoForApi mapVoForApi = new MapVoForApi();
                mapVoForApi.setAddressName(map.getAddressName());
                mapVoForApi.setCategoryGroupCode(map.getCategoryGroupCode());
                mapVoForApi.setCategoryGroupName(map.getCategoryGroupName());
                mapVoForApi.setCategoryName(map.getCategoryName());
                mapVoForApi.setDistance(map.getDistance());
                mapVoForApi.setId(map.getId());
                mapVoForApi.setPhone(map.getPhone());
                mapVoForApi.setPlaceName(map.getPlaceName());
                mapVoForApi.setPlaceUrl(map.getPlaceUrl());
                mapVoForApi.setRoad_addressName(map.getRoad_addressName());
                mapVoForApi.setX(map.getX());
                mapVoForApi.setY(map.getY());

                MapVoForApi searchMap = this.mapServiceForApi.retrieveMap(map.getId());
                //신규 숙소인 경우
                if (searchMap.getId() == 0) {
                    String registerMapUri = this.mapServiceForApi.registerMap(mapVoForApi);
                }

                ReviewVo review = new ReviewVo();

                if (getReview.getVisitDate().trim().equals("")) {
                    getReview.setVisitDate(null);
                }

                review.setPostNo(postNo);
                review.setRoomNo(map.getId());
                review.setRateLoc(getReview.getRateLoc());
                review.setRateClean(getReview.getRateClean());
                review.setRateComu(getReview.getRateComu());
                review.setRateChip(getReview.getRateChip());
                review.setVisitDate(getReview.getVisitDate());
                review.setRecommendPlace(getReview.getRecommendPlace());
                review.setNotRecommendPerson(getReview.getNotRecommendPerson());
                this.reviewService.registerReview(review);
            }
        }


        if (board.getUsePhoto() == 1) {
            // 이미지
            if (images != null) {
                for (MultipartFile file : images) {
                    String fileName = null;
                    if (!file.getOriginalFilename().isEmpty()) {
                        fileName = fileUploadService.restore(file, postNo, 1);
                    } else {
                        fileName = "default.jpg";
                    }
                }
            }
        }


        if (board.getUseVideo() == 1) {
            // 동영상
            if (videos != null) {
                for (MultipartFile file : videos) {
                    String fileName = null;
                    if (!file.getOriginalFilename().isEmpty()) {
                        fileName = fileUploadService.restore(file, postNo, 2);
                    } else {
                        fileName = "default.mp4";
                    }

                }
            }
        }
        return "redirect:/board/" + post.getBoardNo() + "/post/" + postVo.getPostNo();
    }
}
