package top.tomxwd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xieweidu
 * @createDate 2019-12-06 23:03
 */
@SpringBootApplication
// EurekaServer服务端启动类，接受其他微服务注册进来
@EnableEurekaServer
public class EurekaServer7003_App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003_App.class,args);
    }

}
