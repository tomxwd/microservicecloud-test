package top.tomxwd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author xieweidu
 * @createDate 2019-12-08 13:07
 */
@SpringBootApplication
@EnableEurekaClient
// 在启动微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
@EnableFeignClients(basePackages = {"top.tomxwd.springcloud"})
public class DeptConsumer80_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }

}