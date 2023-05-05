package com.example.domain;

public interface StoreService {
    StoreDto getById(Long id);

    StoreDto save(StoreDto storeDto);
}
