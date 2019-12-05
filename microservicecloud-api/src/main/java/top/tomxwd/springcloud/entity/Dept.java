package top.tomxwd.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 必须序列化
 * @author xieweidu
 * @createDate 2019-12-04 22:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    /** 主键 */
    private Long deptno;
    /** 部门名称 */
    private String dname;
    /** 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库 */
    private String db_source;

    /**
     * 仅传入部门名的构造函数
     * @param dname
     */
    public Dept(String dname) {
        this.dname = dname;
    }
}
