package top.tomxwd.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import top.tomxwd.springcloud.entity.Dept;

import java.util.List;

/**
 * 不要忘记添加@Component注解
 * @author xieweidu
 * @createDate 2019-12-08 17:49
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("该ID: "+id+"没有找到对应的信息,Consumer客户端提供的降级信息，此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
