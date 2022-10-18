package com.ll.mutbook.post;

import com.ll.mutbook.exception.DataNotFoundException;
import com.ll.mutbook.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getList(){
        return this.postRepository.findAll();
    }

    public Post getPost(Integer id) {
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()) {
            return post.get();
        }else {
            throw new DataNotFoundException("데이터를 찾을 수 없습니다.");
        }
    }

    public void create(String subject, String content, String hashtag, SiteUser user) {
        Post p = new Post();
        p.setSubject(subject);
        p.setContent(content);
        p.setHashTag(hashtag);
        p.setAuthor(user);
        p.setCreateDate(LocalDateTime.now());
        this.postRepository.save(p);
    }

    public void modify(Post post, String subject, String content, String hashtag) {
        post.setSubject(subject);
        post.setContent(content);
        post.setHashTag(hashtag);
        post.setModifyDate(LocalDateTime.now());
        this.postRepository.save(post);
    }

    public void delete(Post post) {
        this.postRepository.delete(post);
    }
}
