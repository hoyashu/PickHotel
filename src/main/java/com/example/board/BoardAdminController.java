package com.example.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class BoardAdminController {

    @Autowired
    private BoardService boardService;

    // ######## 게시판 그룹 관리 ########
    //게시판 그룹 목록 조회
    @GetMapping("/intranet/boardgroup_list")
    public String boardGroupList() {
        return "page/intranet/boardgroup_list";
    }

    // ######## 게시판 관리 ########
    // 게시판 만들기 폼
    @GetMapping("/intranet/board/write")
    public String boardWrite() {

        return "page/intranet/board_write";

    }

    // ######## 게시판 등록 ########
    @PostMapping("/intranet/board/add")
    public String boardAdd(@Valid BoardVo board) {

        // 게시판 정보 추가
        boardService.insertBoard(board);

        return "redirect:/intranet/board/list";
    }

    // ######## 게시판 목록 조회 ########
    @GetMapping("/intranet/board/list")
    public String boardList(Model model) {
        List<BoardVo> boardList = boardService.retrieveBoardList();

        model.addAttribute("boardList", boardList);

        return "page/intranet/board_list";

    }

    // 게시판 상세 조회(수정 폼 보기)
    @GetMapping({"/intranet/board/{boardNo}", "/intranet/board/"})
    public String boardDetail(@PathVariable int boardNo, Model model) {
        BoardVo board = boardService.selectBoard(boardNo);

        model.addAttribute("board", board);

        return "page/intranet/board_modify";
    }

    // 게시판 수정하기 버튼 눌렀을때
    @PostMapping("/intranet/board/modify")
    public String boardModify(BoardVo board) {

        boardService.updateBoard(board);

        return "redirect:/intranet/board/list";
    }

    // 게시판 삭제하기 버튼 눌렀을때
    @ResponseBody
    @GetMapping("/intranet/board_delete/{boardNo}")
    public String boardDelete(@PathVariable int boardNo) {

        boardService.deleteBoard(boardNo);

        return "success";
    }
}
