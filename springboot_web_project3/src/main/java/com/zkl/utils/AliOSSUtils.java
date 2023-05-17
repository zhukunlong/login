package com.zkl.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.zkl.pojo.AliOSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author zkl
 * @date 2023/4/25
 * @time 17:13
 **/
@Component //当前类对象由Spring创建和管理
public class AliOSSUtils {
    @Autowired//注入配置参数实体类对象
    private AliOSSProperties aliOSSProperties;

    public String upload(MultipartFile multipartFile) throws IOException {
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();
        String bucketName = aliOSSProperties.getBucketName();
//              获取上传的文件的输入流
        InputStream inputStream = multipartFile.getInputStream();
//              避免文件覆盖
        String originalFilename = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
//              上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, fileName, inputStream);
//              文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName +"." + endpoint.split("//")[1] + "/" + fileName;
//              关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }
}
