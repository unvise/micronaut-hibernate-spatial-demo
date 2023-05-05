package com.example.config;

import com.example.domain.StoreDto;
import jakarta.inject.Inject;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "jsr330")
public abstract class GeometryMapper {
    @Inject
    private GeometryFactory geometryFactory;

    @Named("toLatitude")
    public Double toLatitude(Point point) {
        return point.getX();
    }

    @Named("toLongitude")
    public Double toLongitude(Point point) {
        return point.getY();
    }

    @Named("toPoint")
    public Point toPoint(StoreDto storeDto) {
        return geometryFactory.createPoint(new Coordinate(storeDto.getLatitude(), storeDto.getLongitude()));
    }
}
