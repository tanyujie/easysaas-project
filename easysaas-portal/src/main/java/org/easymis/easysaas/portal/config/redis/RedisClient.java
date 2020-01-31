package org.easymis.easysaas.portal.config.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisClient {
	private JedisPool jedisPool;

    /**
     * 设置值
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param value
     * @param exptime
     * @throws Exception
     */
    public void setWithExpireTime(String key, String value, int exptime) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value, "NX", "EX", 300);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    //得到值
    public String get(String key) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null)
                jedis.close();
        }
        return null;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    //删除
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.del(key);
    }

    /**
     * 到时自动销毁
     *
     * @param key
     * @param seconds 秒
     */
    public Long expire(final String key, final int seconds) {
        Jedis jedis = jedisPool.getResource();
        return jedis.expire(key, seconds);
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.exists(key);
    }

}
