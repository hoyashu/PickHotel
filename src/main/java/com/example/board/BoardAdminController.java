package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BoardAdminController {

    @Autowired
    private BoardService boardService;

    // ######## 게시판 그룹 관리 ########
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

    // 게시판 등록 눌렀을 때 작동
    @PostMapping("/intranet/board/add")
    public String boardAdd(BoardVo board) {
        // 게시판 정보 추가
        boardService.insertBoard(board);
        return "redirect:/intranet/board/list";
    }

    /* 게시판 목록 */
    @GetMapping("/intranet/board/list")
    public String boardList(Model model) {
        List<BoardVo> boardList = boardService.retrieveBoardList();
        model.addAttribute("boardList", boardList);
        return "page/intranet/board_list";
    }

    // 게시판 상세 조회(수정 폼 보기)
    @GetMapping({ "/intranet/board/{boardNo}", "/intranet/board/" })
    public String boardDetail(@PathVariable(required = false) Integer boardNo, Model model) {
        if (boardNo == null)
            boardNo = 1;
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
    @GetMapping({ "/intranet/board_delete/{boardNo}", "/intranet/board_delete/" })
    public String boardDelete(@PathVariable(required = false) Integer boardNo) {
        if (boardNo == null)
            boardNo = 1;
        boardService.deleteBoard(boardNo);

        return "success";
    }
}
