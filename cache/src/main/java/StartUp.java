import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

/**
 * @describe:
 * @author: ZH
 * @date: 2017/11/16 17:06
 * @version:
 **/
public class StartUp {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring*.xml");
        JedisCluster cluster = (JedisCluster)applicationContext.getBean("cluster");
        cluster.hkeys("*").stream().forEach(k -> System.out.println(k));

    }
}
