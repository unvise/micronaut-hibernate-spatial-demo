package com.example.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import jakarta.persistence.*;

@Getter
@Setter
@Introspected
@Entity
@Table(schema = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "geometry")
    private Point point;
}
