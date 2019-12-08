package top.tomxwd.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    private DeptService service = null;

    @GetMapping(value = "/dept/get/{id}")
    // 一旦调用服务方法失败并抛出了错误信息之后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.service.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID: " + id + " 没有找到对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("该ID: " + id + "没有找到对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

}
