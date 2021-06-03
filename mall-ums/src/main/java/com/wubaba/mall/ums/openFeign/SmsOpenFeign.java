package com.wubaba.mall.ums.openFeign;

import com.wubaba.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wjx
 * @create 2021-06-02 10:05
 */
@FeignClient("mall-sms")
public interface SmsOpenFeign {

    @RequestMapping("sms/smscoupon/info/{id}")
    R info(@PathVariable("id") Long id); 
}
