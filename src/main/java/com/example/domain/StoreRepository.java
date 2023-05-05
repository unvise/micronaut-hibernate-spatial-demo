package com.example.domain;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
}
