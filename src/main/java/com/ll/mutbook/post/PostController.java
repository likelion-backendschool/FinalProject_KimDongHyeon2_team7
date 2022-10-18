package com.ll.mutbook.post;

import com.ll.mutbook.user.SiteUser;
import com.ll.mutbook.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model){
        List<Post> postList = this.postService.getList();
        model.addAttribute("postList", postList);

        return "post_list";
    }

    @GetMapping("/{id}")
    public String detailPage(Model model, @PathVariable("id") Integer id){
        Post post = this.postService.getPost(id);
        model.addAttribute("post", post);

        return "post_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/write")
    public String addPost(PostForm postForm){
        return "post_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/write")
    public String addPost(@Valid PostForm postForm, BindingResult bindingResult, Principal principal){


        if(bindingResult.hasErrors()){
            return "post_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.postService.create(postForm.getSubject(), postForm.getContent(), postForm.getHashtag(), siteUser);
        return "redirect:/post/list";
    }

    @GetMapping("/{id}/modify")
    @ResponseBody
    public String modifyPost(){
        return "글 수정";
    }

    @PostMapping("/{id}/modify")
    @ResponseBody
    public String modifyPost(@RequestParam String a){
        return "글 수정 전송";
    }

    @GetMapping("/{id}/delete")
    @ResponseBody
    public String deletePost(){
        return "글 삭제";
    }

}
