package com.ll.mutbook.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String username, String userNickname, String email, String passward){
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setUserNickname(userNickname);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(passward));
        this.userRepository.save(user);

    }
}
