package com.itest.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectMetadata;
import com.itest.config.OSSConfig;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * OSS工具类
 *
 * @author ChanV
 * @create 2020-12-22-9:32
 */
@Repository
public class OSSUtil {

    private static OSSConfig config = null;

    //OSS上传图片文件
    public String uploadImgFile(MultipartFile file){
        config = config == null ? new OSSConfig():config;
        OSS ossClient = null;
        String fileName = file.getOriginalFilename();
        String folder = contentType(fileName.substring(fileName.lastIndexOf(".") + 1));
        String objectName = folder + UUID.randomUUID() + fileName;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/jpg");

        try {
            ossClient = new OSSClientBuilder().build(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
            ossClient.putObject(config.getBucketName(), objectName, new ByteArrayInputStream(file.getBytes()), metadata);
            String[] url = getUrl(objectName).split("\\?");
            return url[0];
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }
        return "error";
    }

    //OSS上传视频文件
    public String uploadVideoFile(MultipartFile file){
        config = config == null ? new OSSConfig():config;
        OSS ossClient = null;
        String fileName = file.getOriginalFilename();
        String folder = contentType(fileName.substring(fileName.lastIndexOf(".") + 1));
        String objectName = folder + UUID.randomUUID() + fileName;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("video/mp4");

        try {
            ossClient = new OSSClientBuilder().build(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
            ossClient.putObject(config.getBucketName(), objectName, new ByteArrayInputStream(file.getBytes()), metadata);
            String[] url = getUrl(objectName).split("\\?");
            return url[0];
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }
        return "error";
    }

    //获得URL连接
    public String getUrl(String objectName){
        config = config == null ? new OSSConfig():config;
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        //生成URL
        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
        URL url = ossClient.generatePresignedUrl(config.getBucketName(), objectName, expiration);
        if (url != null){
            return url.toString();
        }
        return null;
    }

    //根据文件类型分配文件夹
    private static String contentType(String fileType){
        fileType = fileType.toLowerCase();
        String folder = "";
        switch (fileType){
            case "bmp":
            case "gif":
            case "png":
            case "jpg":
            case "jpeg": folder = "images/";
                break;

            case "html":
            case "txt":
            case "xml": folder = "text/";
                break;

            case "map3": folder = "map3/";
                break;

            case "vsd":
            case "ppt":
            case "pptx":
            case "doc":
            case "docx": folder = "application/";
                break;
            case "mp4": folder = "video/";
                break;
        }
        return folder;
    }

    //列举文件
    public List<OSSObjectSummary> listFile(){
        //存数据库
        return null;
    }

    //删除文件
    public boolean deleteFile(String objectName){
        config = config == null ? new OSSConfig():config;
        OSS ossClient = null;
        String folder = contentType(objectName.substring(objectName.lastIndexOf(".") + 1));
        try {
            ossClient = new OSSClientBuilder().build(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
            ossClient.deleteObject(config.getBucketName(), folder+objectName);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }
        return false;
    }

}
