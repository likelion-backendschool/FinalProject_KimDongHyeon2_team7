package com.ll.mutbook;

import com.ll.mutbook.post.Post;
import com.ll.mutbook.post.PostRepository;
import com.ll.mutbook.post.PostService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MutbookApplicationTests {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostService postService;

	@Test
	void testJpa() {
		Post q1 = new Post();
		q1.setSubject("멋북이 무엇인가요?");
		q1.setContent("멋북에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.postRepository.save(q1);  // 첫번째 질문 저장

		Post q2 = new Post();
		q2.setSubject("멋사 질문입니다.");
		q2.setContent("지금 뭐하시는건가요?");
		q2.setCreateDate(LocalDateTime.now());
		this.postRepository.save(q2);  // 두번째 질문 저장

		List<Post> all = this.postRepository.findAll();
		assertEquals(2, all.size());

		Post q = all.get(0);
		assertEquals("멋북이 무엇인가요?", q.getSubject());
	}

	@Test
	void 테스트_데이터_생성(){
		for(int i = 1; i < 300; i++){
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용 없음.";
			String hashtag = "#야호 #신난다";
			this.postService.create(subject, content, hashtag);
		}
	}

}
