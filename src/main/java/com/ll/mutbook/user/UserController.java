package com.ll.mutbook.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class UserController {

    @GetMapping("/login")
    public String loginForm(){
        return "로그인 화면";
    }

    @PostMapping("/login")
    public String postLoginForm(){
        return "로그인 화면 전송";
    }

    @GetMapping("/logout")
    public String logout(){
        return "로그아웃 됨";
    }

    @GetMapping("/join")
    public String singUpForm(){
        return "회원가입 폼 화면";
    }

    @PostMapping("/join")
    public String postSignUpForm(){
        return "회원가입 전송";
    }

    @GetMapping("/modify")
    public String modifyMemberInfo(){
        return "회원정보 수정";
    }

    @PostMapping("/modify")
    public String postModifyMemberInfo(){
        return "회원정보 수정 전송";
    }

    @GetMapping("/modifyPassword")
    public String modifyPassword(){
        return "비밀번호 변경";
    }

    @PostMapping("/modifyPassword")
    public String postModifyPassword(){
        return "비밀번호 변경 전송";
    }


}
