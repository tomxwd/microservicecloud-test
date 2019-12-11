package top.tomxwd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xieweidu
 * @createDate 2019-12-05 21:07
 */
@SpringBootApplication
// 本服务启动后会自动注册进Eureka服务中
@EnableEurekaClient
// 服务发现
@EnableDiscoveryClient
public class Config_Git_DeptProvider8001_App {

    public static void main(String[] args) {
        SpringApplication.run(Config_Git_DeptProvider8001_App.class,args);
    }

}
