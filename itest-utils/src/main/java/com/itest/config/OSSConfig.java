package com.itest.config;

import java.io.IOException;

/**
 * OSS配置类
 *
 * @author ChanV
 * @create 2020-12-22-9:33
 */
public class OSSConfig {
    private String endpoint;    //OSS连接路径
    private String bucketName;  //需要存储的bucketName
    private String accessKeyId; //连接KeyId
    private String accessKeySecret; //连接密钥

    public OSSConfig(){
        try {
            this.endpoint = SystemConfig.getConfigProperties("endpoint");
            this.bucketName = SystemConfig.getConfigProperties("bucketName");
            this.accessKeyId = SystemConfig.getConfigProperties("accessKeyId");
            this.accessKeySecret = SystemConfig.getConfigProperties("accessKeySecret");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
