package com.example.board;

import com.example.exception.PostDetailException;
import com.example.board.CommentService;
import com.example.member.MemberService;
import com.example.board.PostService;
import com.example.board.RoomService;
import com.example.board.CommentVo;
import com.example.member.MemberVo;
import com.example.board.PostVo;
import com.example.board.RoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Validated
public class BoardController {

    class notFoundPost extends Exception {
        notFoundPost() {
            super("존재하는 게시글이 아닙니다.");
        }
    }
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
    private CommentService commentService;

    @Autowired
    public MemberService memberService;

    // ########## 게시글 ########## //
    // 게시글 작성 폼
    @GetMapping("/post/write")
    public String writeForm(Model model) {
        int defaultListNo = 1;
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
    public Map checkUse(@RequestParam(value = "boardNo",required = false, defaultValue = "1") int boardNo){
        BoardVo board = this.boardService.selectBoard(boardNo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("board", board);

        return map;
    }


    // 게시글 목록
    @GetMapping("/post/list/{boardNo}")
    public String list(@PathVariable(name = "boardNo", required = false) int boardNo, Model model,
                       HttpServletRequest request) {
        try {
            List<PostVo> posts = postService.retrieveAllPosts(boardNo);
            model.addAttribute("posts", posts);
            model.addAttribute("boardNo", boardNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "page/post_list";
    }

    // 내가 작성한 게시글 목록
    @GetMapping("/member/room")
    public String myList(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        try {
            MemberVo member = (MemberVo) session.getAttribute("member");
            int MemNo = member.getMemNo();
            List<PostVo> posts = this.postService.retrieveMyPosts(MemNo);
            model.addAttribute("posts", posts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "page/member_room";
    }

    // 회원이 작성한 게시글 목록 (회원 정보 확인/회원이 작성한 글)
    @GetMapping("/member/{memNo}")
    public String memberWriteList(@PathVariable("memNo") int memNo, Model model) {
        try {
            List<PostVo> posts = this.postService.retrieveMyPosts(memNo);
            model.addAttribute("posts", posts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "page/member_post_list";
    }

    // 게시글 상세보기
    @GetMapping("/post/{postNo}")
    public String read(@PathVariable("postNo") int postNo, Model model) throws Exception {
        try {
            // 게시글 상세정보
            PostVo post = this.postService.retrieveDetailBoard(postNo);
            if (post == null) {
                throw new notFoundPost();
            }
            List<AttachVo> attachVoList = this.attachService.retrievePostAttach(postNo);
            ReviewVo review = this.reviewService.retrieveReview(postNo);
            BoardVo board = this.boardService.selectBoard(post.getBoardNo());
            RoomVo room = new RoomVo();
            if(review != null){
                room = this.roomService.retrieveRoom(review.getRoomNo());
            }

            model.addAttribute("post", post);
            model.addAttribute("attachList", attachVoList);
            model.addAttribute("review", review);
            model.addAttribute("room", room);


            // 댓글 상세정보 -- 소진 : 이걸 따로 분리할 수 없을까? comment컨트롤러에도 있는 내용임..
            List<CommentVo> comments = this.commentService.retrieveCommentList(postNo);
            for (CommentVo commentVo : comments) {
                // DB에서 대댓글의 댓글인 경우 대댓글 작성자의 닉네임 가져오기
                int parentMemNo = commentVo.getParentMemNo();
                if (parentMemNo > 0) {
                    String parentMemNick = memberService.retrieveMember(parentMemNo).getNick();
                    commentVo.setParentMemNick(parentMemNick);
                }
            }
            model.addAttribute("comments", comments);
        } catch (Exception e) {
            throw new notFoundPost();
        }
        return "page/post_detail";
    }

    // 게시글 수정폼
    @GetMapping("/post/modify/{postNo}")
    public String modifyFrom(@PathVariable("postNo") int postNo, HttpServletRequest request, Model model) {

        //요청 주소로 해당 게시글 pk를 가져옴
        //String rUrl = request.getHeader("REFERER").toString();
        //int idx = rUrl.lastIndexOf("/");
        //int postNo = Integer.parseInt(rUrl.substring(idx+1));
        //System.out.println("postNo"+postNo);

        try {
            List<String> boardNames = this.postService.retrieveBoardName();
            HashMap<Integer, String> boardList = new HashMap<Integer, String>();
            int i = 1;
            for (String string : boardNames) {
                boardList.put(i, string);
                i++;
            }
            model.addAttribute("boardList", boardList);

            PostVo post = this.postService.retrieveDetailBoard(postNo);

            model.addAttribute("post", post);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "page/post_modify";
    }

    // 게시글 수정
    @PostMapping("/post/update")
    public String update(PostVo post) {
        try {
            // 값 셋팅
            PostVo postVo = new PostVo();
            postVo.setPostNo(post.getPostNo());
            postVo.setBoardNo(post.getBoardNo());
            postVo.setSubject(post.getSubject());
            postVo.setContent(post.getContent());
            postVo.setTag(post.getTag());
            // 수정 실행
            this.postService.modifyPost(postVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/post/" + post.getPostNo();
    }

    // 게시글 삭제
    @GetMapping("/post/delete/{postNo}")
    public String delete(@PathVariable("postNo") int postNo) {
        int boardNo = 0;
        try {
            PostVo post = this.postService.retrieveDetailBoard(postNo);
            if (post == null) {
                throw new notFoundPost();
            }
            // 해당 게시글의 board pk값 받아옴 (삭제 후 목록이로 이동하기 위함)
            boardNo = post.getBoardNo();
            // 삭제 실행
            this.postService.removePost(postNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(postNo + "abcde");
        return "redirect:/post/list/" + boardNo;
    }


}
