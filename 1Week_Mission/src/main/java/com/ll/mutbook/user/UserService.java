package com.ll.mutbook.user;

import com.ll.mutbook.exception.DataNotFoundException;
import com.ll.mutbook.user.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public void create(String username, String userNickname, String email, String passward){
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setUserNickname(userNickname);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(passward));
        this.userRepository.save(user);

        emailService.sendWelcomeMessage(user.getEmail());

    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("사이트 유저가 존재하지 않습니다.");
        }
    }
}
