package com.wubaba.mall.pms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wubaba.mall.pms.entity.CategoryEntity;
import com.wubaba.mall.pms.service.CategoryService;
import com.wubaba.common.utils.R;



/**
 * 商品三级分类
 *
 * @author wujuxuan
 * @email 10742869@gmail.com
 * @date 2021-06-02 09:47:24
 */
@RestController
@RequestMapping("pms/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("pms:category:list")
    public R list(Page page, CategoryEntity entity){
        Page<CategoryEntity> pageData = categoryService.page(page, Wrappers.query(entity));
        return R.ok().put("page", pageData);
    }


    /**
     * 列表
     */
    @RequestMapping("/listWithTree")
    public R listWithTree(){
        List<CategoryEntity> categoryEntities = categoryService.listWithTree();
        return R.ok().put("data",categoryEntities);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
   // @RequiresPermissions("pms:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("pms:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("pms:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("pms:category:delete")
    public R delete(@RequestBody Long[] catIds){
        categoryService.delete(Arrays.asList(catIds));
        return R.ok();
    }

}
