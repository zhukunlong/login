package com.zkl.service.impl;

import com.zkl.mapper.DepMapper;
import com.zkl.pojo.Dept;
import com.zkl.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 15:34
 **/
@Service//将当前实现类交给ioc管理
public class DepServiceImpl implements DepService {
    @Autowired
    private DepMapper depMapper;
    @Override
    public List<Dept> selectAll() {
        return depMapper.selectAll();
    }

    @Override
    public void delete(Integer id) {
        depMapper.detectById(id);
    }

    @Override
    public void Insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        depMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        depMapper.update(dept);
    }

}
