package cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.connection.DataType;

/**
 * @describe: 提供cache api
 * @author: ZH
 * @date: 2018/1/16 11:26
 * @version:
 **/
public interface CacheService {
    /**
     * key的分割符
     */
    String separator = "_";

    /**
     * 该方法生成存储使用的key 如type=String c=Drug define =[id,666]则最终在redis中的key为 string_Drug_id_666
     *
     * @param type   使用redis存储的数据类型 (string,list,set,zset,hash)
     * @param c      存储数据所对应的实体
     * @param define key自定义部分
     * @return 存储在缓存中的key
     */
    default String getKey(DataType type, Class c, String... define) {
        StringBuilder sb = new StringBuilder();
        sb.append(type.code()).append(separator).append(c.getSimpleName());
        for (String s : define) {
            sb.append(separator).append(s);
        }
        return sb.toString();
    }

    /**
     * 判断key是否存在
     *
     * @param key 存储key
     * @return true or false
     */
    boolean exist(String key);

    /**
     * 清除指定缓存
     *
     * @param key key
     */
    void delete(String key);

    /**
     * 获取离过期剩余秒数
     *
     * @param key 存储key
     * @return 剩余秒数
     */
    long getExpire(String key);

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds 以秒为单位
     * @return 是否设置成功
     */
    boolean expire(String key, long seconds);

    /**
     * 验证指定key的数据类型
     *
     * @param key 存储key
     * @return (string, list, set, zset, hash) 指定的key不存在则返回none
     */
    String type(String key);

    /**
     * 以String方式缓存数据
     *
     * @param data    需要缓存的数据
     * @param seconds 设置当前缓存的过期时间,如果不设置过期，
     *                则写成null,时间单位是秒
     * @param keys    自定义keys
     * @param <T>     存储数据范型
     */
    <T> void cacheWithString(T data, Long seconds, String... keys);

    /**
     * 从String的缓存中读取数据
     *
     * @param c    数据对应的类型
     * @param keys 自定义keyss
     * @param <T>  存储数据范型
     * @return T 实例
     */
    <T> T readFromString(Class<T> c, String... keys);

    /**
     * 将数据缓存到list结构中
     *
     * @param data    需要缓存的数据
     * @param c       数据对应的class类型
     * @param seconds 设置当前缓存的过期时间,如果不设置过期，
     *                则写成null,时间单位是秒
     * @param keys    自字义部分的key
     * @param <T>     存储数据范型
     */
    <T> void cacheWithList(Collection<T> data, Class<T> c, Long seconds, String... keys);

    /**
     * 从缓存中读取数据
     *
     * @param c     数据对应的class类型
     * @param start 如果需要执行分页,start end是非常有用的参数，
     *              注意：在redis中end下标对应的数据是会返回的，如 start= 0 ,end = 10 则会返回11条数据
     *              如果需要获得全部数据 指定start=0 end =-1即可
     * @param end
     * @param keys  自字义部分的key
     * @param <T>   存储数据范型
     */
    <T> List<T> readFromList(Class<T> c, long start, long end, String... keys);


    /**
     * @param data    缓存的数据
     * @param c       class类型
     * @param seconds 有效时长
     * @param keys    自字义部分的key
     * @param <T>     存储数据范型
     */
    <T> void cacheWithHash(Map<String, T> data, Class<T> c, Long seconds, String... keys);

    /**
     * @param listKey 需要读取的key
     * @param c       class类型
     * @param keys    自字义部分的key
     * @param <T>     存储数据范型
     * @return
     */
    <T> List<T> readFromHash(Collection<String> listKey, Class<T> c, String... keys);

    /**
     * @param c    解析数据类型
     * @param keys 自定义key
     * @param <T>  存储数据范型
     * @return     指定key中所有的k-v数据
     */
    <T> Map<String,T> readAllFromHash(Class<T> c, String... keys);

    /**
     * @param  key 指定的key
     * @return key为集合对象，则返回其size,若为string则返回其长度,
     * 注:该方法依赖key生成规则，如果key规则改变，此方法将作对应修改
     */
    long count(String key);

}
