package com.wubaba.mall.pms.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wubaba.mall.pms.entity.AttrEntity;
import com.wubaba.mall.pms.service.AttrService;
import com.wubaba.common.utils.R;



/**
 * 商品属性
 *
 * @author wujuxuan
 * @email 10742869@gmail.com
 * @date 2021-06-02 09:47:24
 */
@RestController
@RequestMapping("pms/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表获取属性分组的相关信息 需要传递一个catelogId来查询
     */
    @RequestMapping("/list")
    //@RequiresPermissions("pms:attr:list")
    public R list(Page page, AttrEntity entity){
        Page<AttrEntity> pageData = attrService.page(page, Wrappers.query(entity));
        return R.ok().put("page", pageData);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
   // @RequiresPermissions("pms:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getById(attrId);
        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("pms:attr:save")
    public R save(@RequestBody AttrEntity attr){
		attrService.save(attr);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("pms:attr:update")
    public R update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("pms:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));
        return R.ok();
    }

}
