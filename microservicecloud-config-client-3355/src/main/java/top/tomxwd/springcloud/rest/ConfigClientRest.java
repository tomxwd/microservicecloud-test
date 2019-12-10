package top.tomxwd.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xieweidu
 * @createDate 2019-12-10 23:24
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        String str = "applicationName: " + applicationName + "\t eurekaServers: " + eurekaServers + "\t port: " + port;
        System.out.println("*****************" + str);
        return str;
    }

}