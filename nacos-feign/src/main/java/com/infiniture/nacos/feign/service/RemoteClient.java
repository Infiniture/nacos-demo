package com.infiniture.nacos.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.infiniture.nacos.feign.service.impl.RemoteClientImpl;

@FeignClient(name = "nacos-provider", fallback = RemoteClientImpl.class)
public interface RemoteClient {

    @GetMapping("/helloNacos")
    String hellNacos();
}
