package com.wubaba.mall.sms.dao;

import com.wubaba.mall.sms.entity.SmsCouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author wujuxuan
 * @email 10742869@gmail.com
 * @date 2021-06-02 10:01:50
 */
@Mapper
public interface SmsCouponDao extends BaseMapper<SmsCouponEntity> {
	
}
