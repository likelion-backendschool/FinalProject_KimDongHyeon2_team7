package com.ll.mutbook.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class UserController {

    private final UserService userService;

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
        return "signup_form";
    }

    @PostMapping("/join")
    public String signUpForm(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            bindingResult.rejectValue("password2", "passwordInCorrect", "두 개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        userService.create(userCreateForm.getUsername(), userCreateForm.getUserNickname(), userCreateForm.getEmail(), userCreateForm.getPassword1());

        return "redirect:/";
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
