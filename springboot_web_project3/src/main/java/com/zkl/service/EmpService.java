package com.zkl.service;

import com.zkl.pojo.Emp;
import com.zkl.pojo.PageBean;
import java.time.LocalDate;
import java.util.List;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 15:33
 **/
public interface EmpService {
    PageBean page(Integer page, Integer pageSize);

    PageBean pagetwo(Integer page,Integer pageSize
    , String name, Short gender, LocalDate begin,
     LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emps);

     Emp selectbyup(Emp emp);

    Emp selectBytwo(String username, String password);

    void deleteById(Integer id);

}
