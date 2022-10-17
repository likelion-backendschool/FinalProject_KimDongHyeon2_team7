package com.ll.mutbook.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public String list(Model model){
        List<Post> postList = this.postService.getList();
        model.addAttribute("postList", postList);

        return "post_list";
    }

    @GetMapping("/{id}")
    public String detailPage(Model model, @PathVariable("id") Integer id){
        return "post_detail";
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
