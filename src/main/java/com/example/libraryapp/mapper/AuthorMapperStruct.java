package com.example.libraryapp.mapper;

import com.example.libraryapp.dto.response.AuthorResponse;
import com.example.libraryapp.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {BookMapperStruct.class})
public interface AuthorMapperStruct {
    AuthorMapperStruct INSTANCE = Mappers.getMapper(AuthorMapperStruct.class);

    @Mapping(target = "authorNameSurname", source = "authorNameSurname")
    @Mapping(target = "bookResponses", source = "books")
    AuthorResponse toResponse(Author author);
}
