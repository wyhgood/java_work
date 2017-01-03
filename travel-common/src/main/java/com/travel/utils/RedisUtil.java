package com.travel.utils;

import java.util.List;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    private static JedisPool jedisPool;
    private static String ip;
    private static int port;

    private RedisUtil() {
    }

    public static void main(String[] args) {
        RedisUtil.init("120.26.49.233", "6379");
        Jedis jedis = RedisUtil.getJedis();
        List cmu = jedis.lrange("cmu", 0, -1);
//        for (String name : cmu) {
//            System.out.println(name);
//        }
        RedisUtil.returnJedis(jedis);
    }

    public static void init(String ip, String port) {
        RedisUtil.ip = ip;
        RedisUtil.port = Integer.parseInt(port);
    }
    
    public static void initJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(5000);
        config.setMaxIdle(5000);
        config.setTestOnBorrow(false);
        jedisPool = new JedisPool((GenericObjectPoolConfig)config, ip, port);
    }
    
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void release() {
        if (jedisPool != null) {
            jedisPool.destroy();
        }
    }

    public static void returnJedis(Jedis jedis) {
        jedisPool.returnResource(jedis);
    }
}