import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @describe:
 * @author: ZH
 * @date: 2017/11/16 17:06
 * @version:
 **/
public class StartUp {


    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring*.xml");
//        JedisCluster cluster = (JedisCluster)applicationContext.getBean("cluster");
//        JedisPool jedisPool;
//        cluster.hkeys("*").stream().forEach(k -> System.out.println(k));
//        Jedis jedis = new Jedis("localhost");
//        jedis.set("foo", "bar");
//        String value = jedis.get("foo");

            Set<HostAndPort> jedisClusterNodes = new HashSet<>();
//Jedis Cluster will attempt to discover cluster nodes automatically
            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6379));
            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6378));
            JedisCluster jc = new JedisCluster(jedisClusterNodes);
            jc.set("foo", "bar");
            String value = jc.get("foo");
            System.out.println(value);
    }
}
