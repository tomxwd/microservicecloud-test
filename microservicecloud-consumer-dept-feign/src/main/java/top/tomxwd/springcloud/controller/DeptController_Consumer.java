package top.tomxwd.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.tomxwd.springcloud.entity.Dept;
import top.tomxwd.springcloud.service.DeptClientService;

import java.util.List;

/**
 * @author xieweidu
 * @createDate 2019-12-05 22:42
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service = null;

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.service.get(id);
    }

    @GetMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return this.service.list();
    }

    @PostMapping(value = "/consumer/dept/add")
    public Object add(Dept dept){
        return this.service.add(dept);
    }

}
