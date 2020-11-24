package com.infiniture.nacos.feign.service.impl;

import com.infiniture.nacos.feign.service.RemoteClient;

public class RemoteClientImpl implements RemoteClient {

    @Override
    public String hellNacos() {
        return "请求超时了";
    }
}
