package com.example.libraryapp.mapper;

import com.example.libraryapp.dto.response.PublisherResponse;
import com.example.libraryapp.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface PublisherMapperStruct {
    PublisherMapperStruct INSTANCE = Mappers.getMapper(PublisherMapperStruct.class);

    @Mapping(target = "publisherName", source = "publisher.publisherName")
    PublisherResponse toResponse(Publisher publisher);
}
