package com.ll.mutbook.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserCreateForm {
    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

    @Size(min = 1, max = 25)
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String username;

    @Size(min = 3, max = 8)
    @NotEmpty(message = "닉네임은 필수항목입니다.")
    private String userNickname;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;


}
