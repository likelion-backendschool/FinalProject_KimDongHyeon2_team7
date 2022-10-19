package com.ll.mutbook.post;

import com.ll.mutbook.exception.DataNotFoundException;
import com.ll.mutbook.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getList(){
        return this.postRepository.findAll();
    }

    /**
     * index 페이지에 쓰일 정렬된 게시물 100개를 슬라이싱하기 위한 메서드
     */
    public static<T> List<T> getSubList(List<T> list, int startIndex, int endIndex) {
        List<T> sublist = new ArrayList<>();
        long index = 0;
        for (T e : list) {
            if (index >= startIndex && index <= endIndex) {
                sublist.add(e);
            } else if (index > endIndex) {
                break;
            }
            index++;
        }
        return sublist;
    }

    public List<Post> get100List(){
        List<Post> subList =  getSubList(this.postRepository.findAll(Sort.by(Sort.Direction.DESC, "createDate")), 0, 99);

        return subList;
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
        p.setHashtag(hashtag);
        p.setAuthor(user);
        p.setCreateDate(LocalDateTime.now());
        this.postRepository.save(p);
    }

    public void modify(Post post, String subject, String content, String hashtag) {
        post.setSubject(subject);
        post.setContent(content);
        post.setHashtag(hashtag);
        post.setModifyDate(LocalDateTime.now());
        this.postRepository.save(post);
    }

    public void delete(Post post) {
        this.postRepository.delete(post);
    }
}
