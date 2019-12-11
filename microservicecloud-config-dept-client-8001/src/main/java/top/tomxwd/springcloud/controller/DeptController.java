package top.tomxwd.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.tomxwd.springcloud.entity.Dept;
import top.tomxwd.springcloud.service.DeptService;

import java.util.List;

/**
 * @author xieweidu
 * @createDate 2019-12-05 21:02
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient client;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "/dept/list")
    public List<Dept> list() {
        return service.list();
    }

    @GetMapping(value = "/dept/discovery")
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**************************" + list);
        List<ServiceInstance> serviceInstanceList = client.getInstances("MICROSERVICECLOUD-DEPT");
        serviceInstanceList.stream().forEach(serviceInstance -> {
            System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t"
                    + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        });
        return this.client;
    }

}
