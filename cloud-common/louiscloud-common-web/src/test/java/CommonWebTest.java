import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author Eric
 * @date create in 2019/5/28
 */
@Slf4j
public class CommonWebTest {

    Jedis jedis = new Jedis("localhost");

    @Before
    public void before() {



    }

    @Test
    public void test() {
        jedis.set("jedis", "hello world");
        log.info("jedis,{}",jedis.get("jedis"));
        log.info("type {}",jedis.type("jedis"));


    }
    @After
    public void after() {

    }

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test2() {
        Map<byte[],byte[]> map = Maps.newHashMap();
        byte[] bytes = new byte[1034 * 1024*100];
        byte[] key = new byte[10*10];

        map.put(key, bytes);
        jedis.hmset(key, map);



    }
}
