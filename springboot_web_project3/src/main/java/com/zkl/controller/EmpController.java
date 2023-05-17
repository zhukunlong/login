package com.zkl.controller;

import com.zkl.pojo.Emp;
import com.zkl.pojo.LoginInfrom;
import com.zkl.pojo.PageBean;
import com.zkl.pojo.Result;
import com.zkl.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 15:27
 **/
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8081",maxAge = 3600)
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize){
      log.info("分页查询");
      PageBean pageBean=empService.page(page,pageSize);
      return Result.success(pageBean);
    }
    @GetMapping("/emps1")
    public Result page1(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize
    , String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询");
        PageBean pageBean=empService.pagetwo(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作，ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }
    @PostMapping("/emps")
    public Result save(@RequestBody LoginInfrom loginInfrom){
        String username = loginInfrom.getUsername();
        String password = loginInfrom.getPassword();
        System.out.println(username);
        System.out.println(password);
        Emp emp = new Emp(username, password);
        log.info("新增员工，emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }


}
