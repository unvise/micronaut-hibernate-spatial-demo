package com.example.domain;

import com.example.config.GeometryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jsr330", uses = GeometryMapper.class)
public interface StoreMapper {
    @Mapping(target = "latitude", source = "point", qualifiedByName = "toLatitude")
    @Mapping(target = "longitude", source = "point", qualifiedByName = "toLongitude")
    StoreDto toDto(Store store);

    @Mapping(target = "point", source = ".", qualifiedByName = "toPoint")
    Store toEntity(StoreDto storeDto);
}
