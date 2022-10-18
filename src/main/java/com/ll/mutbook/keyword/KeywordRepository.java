package com.ll.mutbook.keyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    Keyword findByHashTag(String hashTag);
}
