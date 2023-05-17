package com.zkl.controller;

import com.zkl.pojo.Dept;
import com.zkl.pojo.Result;
import com.zkl.service.DepService;
import com.zkl.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 15:30
 **/
@RestController
@Slf4j
public class DepController {
    @Autowired
    private DepService depService;
    @Autowired
    private EmpService empService;
//    查询部门
    @RequestMapping(value = "/depts",method = RequestMethod.GET)//method = RequestMethod.GET：指定请求方式为get
    //spring提供了@GetMapping注解限定了请求方式为get
    public Result selectAll(){
        log.info("查询所有");
        List<Dept> depts = depService.selectAll();
        return Result.success(depts);
    }
//    删除部门
    @Transactional(rollbackFor = Exception.class)//spring事务管理
    //事务的传播行为，是指在一个事务中加入另一个事务
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门:{}",id);
        depService.delete(id);
        if(true){
            throw new Exception("出错了");
        }
        empService.deleteById(id);
        return Result.success();
    }
//    添加部门
    @RequestMapping(value = "/depts",method = RequestMethod.POST)
    public Result Insert(@RequestBody Dept dept){
        log.info("新增部门");
        depService.Insert(dept);
        return Result.success();
    }
//    修改部门
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        log.info("修改部门");
        depService.update(dept);
        return Result.success();
    }
}
