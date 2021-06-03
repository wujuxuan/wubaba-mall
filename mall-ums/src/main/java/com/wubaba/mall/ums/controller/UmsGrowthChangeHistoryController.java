package com.wubaba.mall.ums.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wubaba.mall.ums.openFeign.SmsOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wubaba.mall.ums.entity.UmsGrowthChangeHistoryEntity;
import com.wubaba.mall.ums.service.UmsGrowthChangeHistoryService;
import com.wubaba.common.utils.R;



/**
 * 成长值变化历史记录
 *
 * @author wujuxuan
 * @email 10742869@gmail.com
 * @date 2021-06-02 09:58:44
 */
@RestController
@RequestMapping("ums/umsgrowthchangehistory")
public class UmsGrowthChangeHistoryController {
    @Autowired
    private UmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    @Autowired
    private SmsOpenFeign smsOpenFeign;
   
    @RequestMapping("testOpenfeign/{id}")
    public R  testOpenfeign(@PathVariable("id") Long id){

        return smsOpenFeign.info(id);
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ums:umsgrowthchangehistory:list")
    public R list(Page page, UmsGrowthChangeHistoryEntity entity){
        Page<UmsGrowthChangeHistoryEntity> pageData = umsGrowthChangeHistoryService.page(page, Wrappers.query(entity));

        return R.ok().put("page", pageData);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("ums:umsgrowthchangehistory:info")
    public R info(@PathVariable("id") Long id){
		UmsGrowthChangeHistoryEntity umsGrowthChangeHistory = umsGrowthChangeHistoryService.getById(id);

        return R.ok().put("umsGrowthChangeHistory", umsGrowthChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ums:umsgrowthchangehistory:save")
    public R save(@RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistory){
		umsGrowthChangeHistoryService.save(umsGrowthChangeHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ums:umsgrowthchangehistory:update")
    public R update(@RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistory){
		umsGrowthChangeHistoryService.updateById(umsGrowthChangeHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ums:umsgrowthchangehistory:delete")
    public R delete(@RequestBody Long[] ids){
		umsGrowthChangeHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
