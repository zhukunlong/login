package com.zkl.service;

import com.zkl.pojo.Dept;

import java.util.List;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 15:33
 **/
public interface DepService {
    public List<Dept> selectAll();

    void delete(Integer id);

    void Insert(Dept dept);

    void update(Dept dept);
}
