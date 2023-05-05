package com.example.domain;

import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller("/stores")
public class StoreController {
    private final StoreService storeService;

    @Get("/{id}")
    public StoreDto getById(@PathVariable Long id) {
        return storeService.getById(id);
    }

    @Post
    public StoreDto save(@Body StoreDto storeDto) {
        return storeService.save(storeDto);
    }
}
