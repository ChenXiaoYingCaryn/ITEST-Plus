package com.itest.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ChanV
 * @create 2021-02-28-14:13
 */
public class FileConvertUtils {


    public static File convert(MultipartFile file){
        File convFile = new File("temp_image", file.getOriginalFilename());
        if (!convFile.getParentFile().exists()) {
            System.out.println("mkdir:" + convFile.getParentFile().mkdirs());
        }
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return convFile;
    }

}
