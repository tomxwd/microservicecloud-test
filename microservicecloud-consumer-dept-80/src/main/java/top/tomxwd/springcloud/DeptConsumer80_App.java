package top.tomxwd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import top.tomxwd.ribbon.rule.MySelfRule;

/**
 * @author xieweidu
 * @createDate 2019-12-05 22:55
 */
@SpringBootApplication
@EnableEurekaClient
// 在启动微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }

}
