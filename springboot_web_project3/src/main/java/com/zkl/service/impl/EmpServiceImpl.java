package com.zkl.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zkl.mapper.EmpMapper;
import com.zkl.pojo.Emp;
import com.zkl.pojo.PageBean;
import com.zkl.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 15:35
 **/
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        Long count = empMapper.count();
        Integer start= (page - 1) * pageSize;
        List<Emp> emps = empMapper.selectEmpAll(start, pageSize);
        PageBean pageBean = new PageBean(count, emps);
        return pageBean;
    }
    @Override
    public PageBean pagetwo(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,
                            LocalDate end){
        PageHelper.startPage(page,pageSize);
        List<Emp> emps = empMapper.selectAll(name,gender,begin,end);
        System.out.println(emps);
        Page<Emp> ppage=(Page<Emp>) emps;
        PageBean pageBean = new PageBean(ppage.getTotal(), ppage.getResult());
        System.out.println(ppage.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emps) {
        emps.setCreateTime(LocalDateTime.now());
        emps.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emps);
    }

    @Override
    public Emp selectbyup(Emp emp) {
        return empMapper.selectByup(emp);
    }

    @Override
    public Emp selectBytwo(String username, String password) {

        return empMapper.selectBytwo(username,password);

    }

    @Override
    public void deleteById(Integer id) {
        empMapper.deleteById(id);
    }
}
