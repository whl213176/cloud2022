package com.hailong.study.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuhailong
 * @date 2022/6/13.
 */

@Component
@FeignClient
public interface PaymentService {

   String PaymentInfo_Ok(@PathVariable("id") Integer id);

   String PaymentInfo_TimeOut(@PathVariable("id") Integer id);

}
