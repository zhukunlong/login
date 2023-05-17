package com.zkl.controller;

import com.zkl.pojo.Emp;
import com.zkl.pojo.LoginInfrom;
import com.zkl.pojo.Result;
import com.zkl.service.impl.EmpServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * @author zkl
 * @date 2023/4/27
 * @time 16:37
 **/
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8081",maxAge = 3600)
public class LoginController {

    @Autowired
    private EmpServiceImpl empService;
    @RequestMapping("/login")
    public Result login(@RequestBody Emp emp){
        System.out.println(emp.getUsername());
        System.out.println(emp.getPassword());
        Emp selectbyup = empService.selectbyup(emp);
        log.info("登陆成功");
        return Result.success(selectbyup);
    }
    @RequestMapping("/login2")
    public Result login2(@RequestBody LoginInfrom loginInfrom){
        String username=loginInfrom.getUsername();
        String password=loginInfrom.getPassword();
        System.out.println(username);
        System.out.println(password);
        Emp emp = empService.selectBytwo(username, password);
        if(emp != null){
            HashMap<String, Object> map = new HashMap<>();
            map.put("username",username);
            map.put("password",password);
            String login = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, "login")
                    .setClaims(map)
                    .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                    .compact();
            return Result.success(login);
        }else {
        return Result.error("密码或用户名错误");
        }

    }
}
