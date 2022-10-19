package com.ll.mutbook.keyword;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-19T14:39:58+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class KeywordMapperImpl implements KeywordMapper {

    @Override
    public KeywordDto toDto(Keyword keyword) {
        if ( keyword == null ) {
            return null;
        }

        KeywordDto keywordDto = new KeywordDto();

        keywordDto.setId( keyword.getId() );
        keywordDto.setHashTag( keyword.getHashTag() );

        return keywordDto;
    }

    @Override
    public List<KeywordDto> toDtoList(List<Keyword> keyword) {
        if ( keyword == null ) {
            return null;
        }

        List<KeywordDto> list = new ArrayList<KeywordDto>( keyword.size() );
        for ( Keyword keyword1 : keyword ) {
            list.add( toDto( keyword1 ) );
        }

        return list;
    }
}
