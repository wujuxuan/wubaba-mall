package com.wubaba.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.sun.imageio.plugins.common.InputStreamAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author wjx
 * @create 2021-06-03 9:03
 *
 * OOS上传文件接口
 */
public class UploadUtils {
    /**
     * 简单文件上传
     */
    public static void simpleUpload(String filePath) throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-shenzhen.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI5tNMTcbahkzHnvjapiew";
        String accessKeySecret = "7ujv0tt8XqoaNs3B2XnaGvNmPyT9Z0";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream in = new FileInputStream(filePath);
        
        ossClient.putObject("mall-wubaba","1.jpg",in);        
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 多文件文件上传
     */
    public static void  MultipleFilesUpload(){
         
    }

}
