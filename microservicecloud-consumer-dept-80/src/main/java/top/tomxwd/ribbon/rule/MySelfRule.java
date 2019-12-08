package top.tomxwd.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xieweidu
 * @createDate 2019-12-07 21:11
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        // 默认是轮询，自定义为随机
//        return new RandomRule();
        // 改为自定义的五次轮询
        return new FiveTimeRobinRule();
    }

}
