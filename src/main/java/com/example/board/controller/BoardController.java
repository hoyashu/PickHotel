package com.example.board.controller;

import com.example.board.model.*;
import com.example.board.service.*;
//import com.example.common.exception.Constants;
import com.example.member.model.MemberVo;
import com.example.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class BoardController {


    @Autowired
    public MemberService memberService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private PostService postService;

    @Autowired
    private AttachService attachService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CommentServiceImpl commentService;

    // ########## 게시글 ########## //
    // 게시글 작성 폼
    @GetMapping("/post/write")
    public String writeForm(@RequestParam(value = "boardNo", required = false) Integer boardNo, Model model, HttpServletRequest request) {

            //게시판 목록을 통해 게시글을 작성하려 할때, 유입된 게시판에 작성이 선택된다.
            int defaultListNo = 0;
            if (boardNo == null) {
                defaultListNo = 1;
            } else {
                defaultListNo = boardNo;
            }

            List<String> boardNames = this.postService.retrieveBoardName();
            HashMap<Integer, String> boardList = new HashMap<Integer, String>();
            int i = 1;
            for (String string : boardNames) {
                boardList.put(i, string);
                i++;
            }

            List<RoomVo> roomList = this.roomService.retrieveRoomList();

            model.addAttribute("roomList", roomList);
            // request 영역에 디폴트 게시판 정보를 저장한다.
            model.addAttribute("defaultListNo", defaultListNo);
            // request 영역에 게시판 리스트 정보를 저장한다.
            model.addAttribute("boardList", boardList);

            return "page/post_write";

    }

    //게시글 작성 시 이미지, 동영상, 리뷰 사용 체크
    @ResponseBody
    @GetMapping("/post/checkUse")
    public Map checkUse(@RequestParam(value = "boardNo", required = false, defaultValue = "1") int boardNo) {
        BoardVo board = this.boardService.selectBoard(boardNo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("board", board);

        return map;
    }

    // 게시글 목록
    @GetMapping("/board/{boardNo}")
    public String list(@PathVariable("boardNo") int boardNo, Model model) {

        //게시판 ID로 해당 게시판 내 게시글 목록을 가져온다.
        List<PostVo> posts = postService.retrieveAllPosts(boardNo);

        //게시판 ID로 해당 게시판 이름을 가져온다
        BoardVo board = boardService.selectBoard(boardNo);

        model.addAttribute("posts", posts);
        model.addAttribute("board", board);

        return "page/post_list";
    }

    // 내가 작성한 게시글 목록
    @GetMapping("/member/room")
    public String myList(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();

        MemberVo member = (MemberVo) session.getAttribute("member");
        int MemNo = member.getMemNo();
        List<PostVo> posts = this.postService.retrieveMyPosts(MemNo);
        model.addAttribute("posts", posts);

        return "page/member_room";
    }

    // 회원이 작성한 게시글 목록 (회원 정보 확인/회원이 작성한 글)
    @GetMapping("/member/{memNo}")
    public String memberWriteList(@PathVariable("memNo") int memNo, Model model) {

        List<PostVo> posts = this.postService.retrieveMyPosts(memNo);
        model.addAttribute("posts", posts);

        return "page/member_post_list";
    }

    // 게시글 상세보기
    @GetMapping("/post/{postNo}")
    public String read(@PathVariable("postNo") int postNo, Model model, HttpServletRequest request, HttpServletResponse response) {

        // ######### 게시글 상세정보 시작 ######### //
        PostVo post = this.postService.retrieveDetailBoard(postNo);
//        if (post == null) {
//            throw new RuntimeException(Constants.ExceptionMsgClass.NOTPOST.getExceptionMsgClass());
//        }
        List<AttachVo> attachVoList = this.attachService.retrievePostAttach(postNo);
        ReviewVo review = this.reviewService.retrieveReview(postNo);
        BoardVo board = this.boardService.selectBoard(post.getBoardNo());
        RoomVo room = new RoomVo();
        if (review != null) {
            room = this.roomService.retrieveRoom(review.getRoomNo());
        }

        model.addAttribute("post", post);
        model.addAttribute("attachList", attachVoList);
        model.addAttribute("review", review);
        model.addAttribute("room", room);
        // ######### 게시글 상세정보 시작 ######### //

        // ######### 게시글 조회수 증가 시작 ######### //
        // 조회수 중복방지는 필요한 기능이지만, 완벽하게 차단해야 할만큼 중대한 사항은 아니라고 생각, 따라서 쿠키를 사용
        Cookie oldCookie = null;
        Cookie[] cookies = request.getCookies();

        //request에서 넘어온 쿠키가 있는 경우
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //이미 게시글을 1개 이상 본 기록이 있는 경우
                if (cookie.getName().equals("postView")) {
                    //게시글 조회 쿠키 기록을 가져온다.
                    oldCookie = cookie;
                }
            }
        }

        //게시글 조회 기록이 있는 경우 (oldCookie = 이전 게시글 조회 기록)
        if (oldCookie != null) {
            log.info("oldCookie:{}", oldCookie.getValue());
            //현재 조회하려는 게시글을 본 쿠키 기록이 없는 경우
            if (!oldCookie.getValue().contains("[" + postNo + "]")) {
                //조회수를 올린다
                postService.upHitcount(postNo);
                // 현재 게시글을 조회했다고 쿠키에 추가한다.
                oldCookie.setValue(oldCookie.getValue() + "_[" + postNo + "]");
                //웹어플리케이션의 모든 URL 범위에서 전송할 수 있도록 Path를 설정해준다.
                oldCookie.setPath("/");
                //하루에 한번만 조회수가 올라가게 한다.
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else { //게시글 조회 기록이 없는 경우
            //조회수를 올린다.
            postService.upHitcount(postNo);
            //게시글 조회 기록 쿠키를 생성한다.
            Cookie newCookie = new Cookie("postView", "[" + postNo + "]");
            //웹어플리케이션의 모든 URL 범위에서 전송할 수 있도록 Path를 설정해준다.
            newCookie.setPath("/");
            //하루에 한번만 조회수가 올라가게 한다.
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }
        // ######### 게시글 조회수 증가 끝 ######### //

        // ######### 댓글 목록 시작 ######### //
        List<CommentVo> comments = this.commentService.retrieveCommentList(postNo);

        model.addAttribute("comments", comments);
        // ######### 댓글 목록 조회 끝 ######### //

        return "page/post_detail";
    }


    // 게시글 수정폼
    @GetMapping("/post/modify/{postNo}")
    public String modifyFrom(@PathVariable("postNo") int postNo, Model model, HttpServletRequest request) {

        // 작성자 본인이거나 관리자 인지 권한 확인
        // 세션 준비
        HttpSession session = request.getSession();
        MemberVo member = (MemberVo) session.getAttribute("member");

            // 회원 id
            int memNo = member.getMemNo();

            // 작성된 게시글 작성자 id
            int writerNo = this.postService.retrieveDetailBoard(postNo).getWriterNo();
            System.out.println("회원" + memNo + "작성자" + writerNo);
            // 작성자 본인이 아닌 경우
            if (memNo != writerNo) {
                //권한 없음 페이지로 이동
                return "redirect:/denine";

            } else {
                // 작성자 본인인 경우
                // 게시글 정보 가져오기
                PostVo post = this.postService.retrieveDetailBoard(postNo);

                //현존하지 않은 게시글인 경우
//                if (post == null) {
//                    throw new RuntimeException(Constants.ExceptionMsgClass.NOTPOST.getExceptionMsgClass());
//                }

                //게시판 목록 정보 가져오기
                List<String> boardNames = this.postService.retrieveBoardName();

                //HashMap 데이터 형에 게시판 목록 담기
                HashMap<Integer, String> boardList = new HashMap<Integer, String>();
                int i = 1;
                for (String string : boardNames) {
                    boardList.put(i, string);
                    i++;
                }
                //게시판 목록 model셋팅
                model.addAttribute("boardList", boardList);

                //게시글 정보 model셋팅
                model.addAttribute("post", post);

                return "page/post_modify";
            }
        }


    // 게시글 수정
    @PostMapping("/post/update")
    public String update(@Valid PostVo post, HttpServletRequest request) {
        // 작성자 본인이거나 관리자 인지 권한 확인
        // 세션 준비
        HttpSession session = request.getSession();
        MemberVo member = (MemberVo) session.getAttribute("member");


            // 회원 id
            int memNo = member.getMemNo();

            // 작성된 게시글 작성자 id
            int writerNo = this.postService.retrieveDetailBoard(post.getPostNo()).getWriterNo();
            System.out.println("회원" + memNo + "작성자" + writerNo);

            // 작성자 본인이 아닌 경우
            if (memNo != writerNo) {
                //권한 없음 페이지로 이동
                return "redirect:/denine";

            } else {
                // 작성자 본인인 경우
                // 값 셋팅
                PostVo postVo = new PostVo();
                postVo.setPostNo(post.getPostNo());
                postVo.setBoardNo(post.getBoardNo());
                postVo.setSubject(post.getSubject());
                postVo.setContent(post.getContent());
                postVo.setTag(post.getTag());

                // 수정 쿼리 실행
                this.postService.modifyPost(postVo);

                return "redirect:/post/" + post.getPostNo();
            }
        }


    // 게시글 삭제
    @GetMapping("/post/delete/{postNo}")
    public String delete(@PathVariable("postNo") int postNo, HttpServletRequest request) {
        // 작성자 본인이거나 관리자 인지 권한 확인
        // 세션 준비
        HttpSession session = request.getSession();
        MemberVo member = (MemberVo) session.getAttribute("member");


            // 회원 id
            int memNo = member.getMemNo();

            // 작성된 게시글 작성자 id
            PostVo post = this.postService.retrieveDetailBoard(postNo);
            int writerNo = post.getWriterNo();
            System.out.println("회원" + memNo + "작성자" + writerNo);
            // 작성자 본인이 아닌 경우
            if (memNo != writerNo) {
                //권한 없음 페이지로 이동
                return "redirect:/denine";

            } else {

                // 작성자 본인인 경우
                // 해당 게시글의 board pk값 받아옴 (삭제 후 목록이로 이동하기 위함)
                int boardNo = post.getBoardNo();

                // 삭제 쿼리 실행
                this.postService.removePost(postNo);

                return "redirect:/board/" + boardNo;
            }
        }

}
