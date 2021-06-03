package com.wubaba.mall.pms;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class MallPmsApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void testUpload() throws FileNotFoundException {

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-shenzhen.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI5tNMTcbahkzHnvjapiew";
        String accessKeySecret = "7ujv0tt8XqoaNs3B2XnaGvNmPyT9Z0";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        InputStream inputStream = new FileInputStream("C:\\Users\\wujuxuan\\Desktop\\1.jpg");
        ossClient.putObject("wubaba-mall","1.jpg",inputStream);

// 关闭OSSClient。
        ossClient.shutdown();
    }

}
