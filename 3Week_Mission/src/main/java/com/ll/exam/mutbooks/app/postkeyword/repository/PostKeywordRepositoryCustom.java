package com.ll.exam.mutbooks.app.postkeyword.repository;

import com.ll.exam.mutbooks.app.postkeyword.entity.PostKeyword;

import java.util.List;

public interface PostKeywordRepositoryCustom {
    List<PostKeyword> getQslAllByAuthorId(Long authorId);
}
