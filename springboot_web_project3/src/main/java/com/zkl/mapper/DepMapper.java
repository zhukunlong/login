package com.zkl.mapper;


import com.zkl.pojo.Dept;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 15:31
 **/
@Mapper
public interface DepMapper {
    @Select("select * from db02.dept")
    List<Dept> selectAll();

    @Delete("delete from db02.dept where id=#{id}")
    void detectById(Integer id);

    @Insert("insert into db02.dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Update("update db02.dept set name=#{name} where id=#{id}")
    void update(Dept dept);
}
