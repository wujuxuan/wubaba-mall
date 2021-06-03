package com.wubaba.mall.pms.service.impl;

import com.wubaba.mall.pms.entity.CategoryBrandRelationEntity;
import com.wubaba.mall.pms.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wubaba.mall.pms.dao.CategoryDao;
import com.wubaba.mall.pms.entity.CategoryEntity;
import com.wubaba.mall.pms.service.CategoryService;
import org.springframework.util.CollectionUtils;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;
    @Override
    public List<CategoryEntity> listWithTree() {

        List<CategoryEntity> entities = this.list();

        List<CategoryEntity> level1Menu = entities.stream().filter(menu -> menu.getParentCid() == 0)
                .peek(menu -> menu.setChildrens(getCategoryEntity(menu, entities)))
                .sorted(Comparator.comparingInt(CategoryEntity::getSort))
                .collect(Collectors.toList());


        return level1Menu;
    }

    @Override
    public void delete(List<Long> asList) {
        //判断是否有绑定品牌
        List<CategoryBrandRelationEntity> catelogId = categoryBrandRelationService.list(new QueryWrapper<CategoryBrandRelationEntity>().in("catelog_id", asList));
        if (!CollectionUtils.isEmpty(catelogId)){
            System.out.println("无法删除，已经绑定了品牌");
            throw new RuntimeException();
        }
        this.removeByIds(asList);
    }

    //递归查找子菜单
    private List<CategoryEntity> getCategoryEntity(CategoryEntity root ,List<CategoryEntity> all){
        //找到子菜单
        List<CategoryEntity> collect = 
                all.stream()
                        .filter(child -> child.getParentCid().equals(root.getCatId()))
                        .peek(child -> child.setChildrens(getCategoryEntity(child,all)))//递归查找子菜单
                        .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))) //排序
                        .collect(Collectors.toList());
        root.setChildrens(collect);
        return collect;
    }
}