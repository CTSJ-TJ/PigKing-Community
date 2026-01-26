package com.example.ctsjamuse.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import java.util.concurrent.TimeUnit;

public class DistributedRateLimiter {
    private final StringRedisTemplate redisTemplate;
    private final int limit = 20;  // 每个用户每分钟的请求限制

    public DistributedRateLimiter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean shouldLimit(String userId) {
        String key = "rate_limiter:" + userId;
//        System.out.println("key:"+key);
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String count = ops.get(key);
        if (count == null) {
            ops.set(key, "1", 60, TimeUnit.SECONDS);  // 设置初始值和过期时间
            return false;
        }

        int countInt = Integer.parseInt(count);
        if (countInt >= limit) {
            return true;
        }

        ops.increment(key);  // 增加计数
        return false;
    }
}