package com.zkl.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zkl
 * @date 2023/4/27
 * @time 10:46
 **/
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")

public class AliOSSProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
