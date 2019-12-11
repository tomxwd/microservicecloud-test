package top.tomxwd.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tomxwd.springcloud.dao.DeptDao;
import top.tomxwd.springcloud.entity.Dept;
import top.tomxwd.springcloud.service.DeptService;

import java.util.List;

/**
 * @author xieweidu
 * @createDate 2019-12-05 21:01
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }
}
