package com.zkl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

//@SpringBootTest
class SpringbootWebProject3ApplicationTests {
//    生成jwt
    @Test
    public void testGetJwt(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("id",1);
        objectObjectHashMap.put("name","tom");
        String itheima = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima")//签名算法
                .setClaims(objectObjectHashMap)//自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//有效时间
                .compact();
        System.out.println(itheima);
    }
    //jwt令牌的解析
    @Test
    public void testParseJwt(){
        Claims itheima = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4MjczNzc4M30.lA_n1o9GaIJxFEE4tTUIqo18lNYiRIKg9sok_3rFyWo")
                .getBody();
        System.out.println(itheima);

    }

}
