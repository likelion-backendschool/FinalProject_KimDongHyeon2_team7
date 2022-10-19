package com.ll.mutbook;

import com.ll.mutbook.post.Post;
import com.ll.mutbook.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final PostService postService;

    @GetMapping("/")
    public String list(Model model){
        List<Post> postList = this.postService.get100List();
        model.addAttribute("postList", postList);

        return "index";
    }
}
