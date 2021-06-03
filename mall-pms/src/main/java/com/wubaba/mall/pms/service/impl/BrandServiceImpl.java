package com.wubaba.mall.pms.service.impl;

import com.wubaba.mall.pms.entity.CategoryBrandRelationEntity;
import com.wubaba.mall.pms.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wubaba.mall.pms.dao.BrandDao;
import com.wubaba.mall.pms.entity.BrandEntity;
import com.wubaba.mall.pms.service.BrandService;
import org.springframework.transaction.annotation.Transactional;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;
    
    @Transactional
    @Override
    public void removeBrandAndRelationByIds(Long[] brandIds) {
        System.out.println("开始删除品牌");
        List<Long> longs = Arrays.asList(brandIds);
        this.removeByIds(longs);
      
        if (longs.contains(1L)){  
            System.out.println("回滚");
            throw new RuntimeException();
        }
        System.out.println("开始删除xx");
        categoryBrandRelationService
                .remove(new QueryWrapper<CategoryBrandRelationEntity>().in("brand_id", longs));
    }
}