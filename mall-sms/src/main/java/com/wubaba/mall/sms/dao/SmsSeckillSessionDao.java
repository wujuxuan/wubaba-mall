package com.wubaba.mall.sms.dao;

import com.wubaba.mall.sms.entity.SmsSeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author wujuxuan
 * @email 10742869@gmail.com
 * @date 2021-06-02 10:01:50
 */
@Mapper
public interface SmsSeckillSessionDao extends BaseMapper<SmsSeckillSessionEntity> {
	
}
