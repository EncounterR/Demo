package com.oranth.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * 多图上传工具类
 * @author WU
 *
 */
public class Upload {
	public static String batchFileUpload(MultipartFile file) {
		try {
            //文件存储位置
            String path="D:/products/wu";
            //这是一个访问路径(如果不配置是访问不到图片的)
            //String basePath="http://192.168.0.00:8080/photo/";
            //获取文件名称
            String fileName = file.getOriginalFilename();  //prefix  suffix
            String suffix=fileName.substring(fileName.lastIndexOf("."));
            //生成新的文件名
            String newFileName= UUID.randomUUID().toString()+suffix;
            //创建文件
            File targetFile = new File(path, newFileName);
            //是否存在
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            System.out.println("上传成功:"+path+newFileName);
            return newFileName;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "上传失败...";
	}
}
