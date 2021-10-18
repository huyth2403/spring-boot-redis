package com.controller;

import com.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/create-cache")
    public String createCache(@RequestParam Map<String, String> map) {
        return mainService.createCache(Integer.parseInt(map.get("key")), map.get("value"));
    }

    @GetMapping("/put-cache")
    public String putCache(@RequestParam Map<String, String> map) {
        return mainService.putCache(Integer.parseInt(map.get("key")), map.get("value"));
    }

    @GetMapping("/evict-cache")
    public String evictCache(@RequestParam Map<String, String> map) {
        mainService.evictCache(Integer.parseInt(map.get("key")));
        return "OK";
    }

}
