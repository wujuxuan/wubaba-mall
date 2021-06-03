package com.wubaba.mall.pms;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wubaba.mall.pms.entity.*;
import com.wubaba.mall.pms.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MallPmsApplicationTests {
    @Autowired
    AttrAttrgroupRelationService attrAttrgroupRelationService;
    
    @Autowired
    AttrService attrService;
    
    @Autowired
    AttrGroupService attrGroupService;
    
    @Autowired
    ProductAttrValueService productAttrValueService;
    
    @Autowired
    SkuInfoService skuInfoService;
    
    @Autowired
    SkuSaleAttrValueService service;

    @Test
    void contextLoads() {
        List<AttrEntity> list = attrService.list(new QueryWrapper<AttrEntity>()
        .ne("attr_type",1));


        List<List<String>> dimvalue =  new ArrayList<>();
        list.forEach( item ->{
            String valueSelect = item.getValueSelect();
            String[] split = valueSelect.split(",");
            System.err.println(Arrays.toString(split));
            dimvalue.add(Arrays.asList(split));
        });

        List<List<String>> result = new ArrayList<>();
        descartes(dimvalue,result,0,new ArrayList<>());
        result.forEach(System.out::println);


        for (int i = 0; i < result.size(); i++) {
            SkuInfoEntity skuInfoEntity = new SkuInfoEntity(null,null,result.get(i).toString(),null,1L,1L, "image",null,null,new BigDecimal("100.1"),0L);
            skuInfoService.save(skuInfoEntity);
        }
    }
    
    @Test
    void gender(){
     

    }
    

    /**
     * 笛卡尔积生成
     */
    private  void descartes(List<List<String>> dimvalue,
                                  List<List<String>> result, int layer, List<String> curList) {
        if (layer < dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                descartes(dimvalue, result, layer + 1, curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    descartes(dimvalue, result, layer + 1, list);
                }
            }
        } else if (layer == dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                result.add(curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    result.add(list);
                }
            }
        }
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
    
    @Test
    void genderSku(){
        
    }

}
