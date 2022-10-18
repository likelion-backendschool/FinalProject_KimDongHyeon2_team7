package com.ll.mutbook.keyword;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface KeywordMapper {
    KeywordMapper mapper = Mappers.getMapper(KeywordMapper.class);

    KeywordDto toDto(Keyword keyword);


    List<KeywordDto> toDtoList(List<Keyword> keyword);
}
