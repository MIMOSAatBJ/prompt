package cache.impl;

import cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @describe:
 * @author: ZH
 * @date: 2018/1/16 15:33
 * @version:
 **/
@Service
@SuppressWarnings("unchecked")
public class CacheServiceImpl implements CacheService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private Jackson2JsonRedisSerializer jsonSerializer;

	public HashOperations<String, String, Object> hashOperations() {
		return redisTemplate.opsForHash();
	}

	public ValueOperations<String, Object> valueOperations() {
		return redisTemplate.opsForValue();
	}

	public SetOperations<String, Object> setOperations() {
		return redisTemplate.opsForSet();
	}

	public ListOperations<String, Object> listOperations() {
		return redisTemplate.opsForList();
	}

	public ZSetOperations<String, Object> zsetOperations() {
		return redisTemplate.opsForZSet();
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}

	public long getExpire(String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	public boolean expire(String key, long seconds) {
		return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
	}

	public String type(String key) {
		return redisTemplate.type(key).code();
	}

	public boolean exist(String key) {
		return redisTemplate.hasKey(key);
	}

	public <T> void cacheWithString(T data, Long seconds, String... keys) {
		String key = getKey(DataType.STRING, data.getClass(), keys);
		valueOperations().set(key, data);
		if (null != seconds && seconds > 0) {
			expire(key, seconds);
		}
	}

	public <T> T readFromString(Class<T> c, String... keys) {
		String key = getKey(DataType.STRING, c, keys);
		return (T) valueOperations().get(key);
	}

	/* rightPushAll 方法有问题，故采用pipeline方式实现 */
	public <T> void cacheWithList(Collection<T> data, Class<T> c, Long seconds, String... keys) {
		String key = getKey(DataType.LIST, c, keys);
		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		connection.openPipeline();
		byte[] bk = redisTemplate.getStringSerializer().serialize(key);
		for (T t : data) {
			connection.rPush(bk, jsonSerializer.serialize(t));
		}
		connection.closePipeline();
		connection.close();
		if (null != seconds && seconds > 0) {
			expire(key, seconds);
		}
	}

	public <T> List<T> readFromList(Class<T> c, long start, long end, String... keys) {
		String key = getKey(DataType.LIST, c, keys);
		return (List<T>) listOperations().range(key, start, end);
	}

	public <T> void cacheWithHash(Map<String, T> data, Class<T> c, Long seconds, String... keys) {
		String key = getKey(DataType.HASH, c, keys);
		hashOperations().putAll(key, data);
		if (null != seconds && seconds > 0) {
			expire(key, seconds);
		}
	}

	public <T> List<T> readFromHash(Collection<String> listKey, Class<T> c, String... keys) {
		String key = getKey(DataType.HASH, c, keys);
		return (List<T>) hashOperations().multiGet(key, listKey);
	}

	public <T> Map<String, T> readAllFromHash(Class<T> c, String... keys) {
		String key = getKey(DataType.HASH, c, keys);
		return (Map<String, T>) hashOperations().entries(key);
	}

	public long count(String key) {
		long size = 0;
		switch (DataType.fromCode(key.split(separator)[0])) {
		case LIST:
			size = listOperations().size(key);
			break;
		case HASH:
			size = hashOperations().size(key);
			break;
		case ZSET:
			size = zsetOperations().size(key);
			break;
		case SET:
			size = setOperations().size(key);
			break;
		case STRING:
			size = valueOperations().size(key);
			break;
		default:
			break;
		}
		return size;
	}
}
