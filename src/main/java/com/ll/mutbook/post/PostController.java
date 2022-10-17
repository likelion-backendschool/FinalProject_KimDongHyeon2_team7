package com.ll.mutbook.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post")
public class PostController {

    @GetMapping("/list")
    @ResponseBody
    public String list(){
        return "전체 리스트 페이지";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String detailPage(){
        return "상세 페이지";
    }

    @GetMapping("/write")
    @ResponseBody
    public String addPost(){
        return "글 등록 페이지";
    }

    @GetMapping("/{id}/modify")
    @ResponseBody
    public String modifyPost(){
        return "글 수정";
    }

    @PostMapping("/{id}/modify")
    @ResponseBody
    public String modifySendPost(){
        return "글 수정 전송";
    }

    @GetMapping("/{id}/delete")
    @ResponseBody
    public String deletePost(){
        return "글 삭제";
    }

}
