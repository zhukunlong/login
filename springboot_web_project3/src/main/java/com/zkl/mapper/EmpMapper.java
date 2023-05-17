package com.zkl.mapper;

import com.zkl.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 15:31
 **/
@Mapper//让接口在编译过程中自动编译实现类
public interface EmpMapper {
    @Select("select count(*) from db02.emp")
    Long count();

    @Select("select * from db02.emp limit #{start},#{pageSize}")
    List<Emp> selectEmpAll(Integer start,Integer pageSize);
//    员工信息的查询
//    @Select(" select * from db02.emp")
    List<Emp> selectAll(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);


    @Insert("insert into db02.emp(username, name, gender, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username},#{name},#{gender},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emps);

    @Select("select * from db02.emp where username=#{username} and password=#{password}")
    Emp selectByup(Emp emp);
    @Select("select * from db02.emp where username=#{username} and password=#{password}")
    Emp selectBytwo(String username, String password);

    @Delete("delete from db02.emp where dept_id=#{id}")
    void deleteById(Integer id);
}
