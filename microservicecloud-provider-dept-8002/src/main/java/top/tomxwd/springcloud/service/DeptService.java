package top.tomxwd.springcloud.service;

import top.tomxwd.springcloud.entity.Dept;

import java.util.List;

/**
 * @author xieweidu
 * @createDate 2019-12-05 20:58
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

}
