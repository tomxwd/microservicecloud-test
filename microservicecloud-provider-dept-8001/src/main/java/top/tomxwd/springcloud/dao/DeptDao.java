package top.tomxwd.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import top.tomxwd.springcloud.entity.Dept;

import java.util.List;

/**
 * @author xieweidu
 * @createDate 2019-12-05 20:52
 */
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();

}
