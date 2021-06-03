package com.wubaba.mall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wubaba.common.utils.PageUtils;
import com.wubaba.mall.pms.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author wujuxuan
 * @email 10742869@gmail.com
 * @date 2021-06-02 09:47:24
 */
public interface CategoryService extends IService<CategoryEntity> {

    List<CategoryEntity> listWithTree();

    void delete(List<Long> asList);
}

