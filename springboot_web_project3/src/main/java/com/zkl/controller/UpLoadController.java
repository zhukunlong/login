package com.zkl.controller;

import com.zkl.pojo.Result;
import com.zkl.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author zkl
 * @date 2023/4/25
 * @time 11:56
 **/
@RestController
@Slf4j
public class UpLoadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
//    在spring-boot文件上传中默认的文件的大小为1M
//    可以再：spring.servlet.multipart.max-file-size=10MB（单个文件的最大值）
//           spring.servlet.multipart.max-request-size=10MB（一次请求所上传所有文件的大小）
//    配置文件的大小
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{}，{}，{}",username,age,image);
        //获取文件的原始名称
        String originalFilename = image.getOriginalFilename();
        //构造唯一的文件名--uuid（通用唯一的标识符）
        int i = originalFilename.lastIndexOf(".");
        String substring = originalFilename.substring(i);
        String s = UUID.randomUUID().toString() + substring;
        log.info("获取新文件名：{}",s);
        image.transferTo(new File("d:\\image\\"+s));
        return Result.success();
    }
    @PostMapping("/upload2")
    public Result upload2(MultipartFile image) throws IOException {
        log.info("文件上传：{}",image.getOriginalFilename());
//        调用阿里云oss工具类进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件的url：{}",url);
        return Result.success(url);
    }
}
