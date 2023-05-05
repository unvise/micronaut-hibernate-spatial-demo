package com.example.domain;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Singleton
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Override
    public StoreDto getById(Long id) {
        return storeRepository.findById(id)
                .map(storeMapper::toDto)
                .orElseThrow();
    }

    @Override
    public StoreDto save(StoreDto storeDto) {
        Store store = storeMapper.toEntity(storeDto);
        Store savedStore = storeRepository.save(store);
        return storeMapper.toDto(savedStore);
    }
}
