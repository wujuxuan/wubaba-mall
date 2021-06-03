package com.wubaba.mall.pms.dao;

import com.wubaba.mall.pms.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author wujuxuan
 * @email 10742869@gmail.com
 * @date 2021-06-02 09:47:24
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
