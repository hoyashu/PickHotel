package com.example.note;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NoteController {

    @GetMapping("/note/list")
    public String noteList() {
        return "page/note_list";
    }

}
