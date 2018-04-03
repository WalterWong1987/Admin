package com.makeronly.common.snowflake;

import org.springframework.beans.factory.annotation.Value;

/**
 * 主键生成器
 * @author Walter Wong
 */
public enum IdGenerator {
    INSTANCE;
    private final IdWorker worker;
    @Value("${workerId}")
    private long workerId;
    @Value("${datacenterId}")
    private long datacenterId;
    IdGenerator(){
        worker = new IdWorker(workerId, datacenterId);
    }

    public Long getId(){
        return pruduceId();
    }

    public String getHexId() {
        return Long.toHexString(pruduceId());
    }

    private Long pruduceId() {
        return worker.nextId();
    }
}
