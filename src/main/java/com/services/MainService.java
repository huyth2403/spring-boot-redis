package com.services;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "token")
public class MainService {

    // value >< cacheNames

    // hàm được chú thích bằng Cacheable sẽ chỉ được thực thi khi cache chưa tồn tại #key - create
    @Cacheable(key = "#key")
    public String createCache(int key, String value) {
        System.out.println("createCache");
        return value;
    }

//    @CachePut(key = "#value.toUpperCase()")
//    @CachePut(key = "#key + 10")
    // hàm được chú thích bằng CachePut luôn luôn được thực thi - update
    @CachePut(key = "#key")
    public String putCache(int key, String value) {
        System.out.println("putCache");
        return value;
    }

    // hàm được chú thích bằng CacheEvict luôn luôn được thực thi, dùng để loại bỏ #key - delete
    @CacheEvict(key = "#key")
    public void evictCache(int key) {
        System.out.println("evictCache");
    }
}
