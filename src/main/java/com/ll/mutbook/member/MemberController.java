package com.ll.mutbook.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    public String loginForm(){
        return "로그인 화면";
    }

    public String postLoginForm(){
        return "로그인 화면 전송";
    }

    public String logout(){
        return "로그아웃 됨";
    }

    public String singUpForm(){
        return "회원가입 폼 화면";
    }

    public String postSignUpForm(){
        return "회원가입 전송";
    }

    public String modifyMemberInfo(){
        return "회원정보 수정";
    }

    public String postModifyMemberInfo(){
        return "회원정보 수정 전송";
    }

    public String modifyPassword(){
        return "비밀번호 변경";
    }

    public String postModifyPassword(){
        return "비밀번호 변경 전송";
    }




}

