package com.ll.mutbook.post;

import com.ll.mutbook.user.SiteUser;
import com.ll.mutbook.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public String modifyPost(PostForm postForm, @PathVariable("id") Integer id, Principal principal){
        Post post = this.postService.getPost(id);
        if(!post.getAuthor().getUsername().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다!");
        }
        postForm.setSubject(post.getSubject());
        postForm.setContent(post.getContent());
        postForm.setHashtag(post.getHashTag());

        return "post_form";
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
