package com.sht.service.impl.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.order.OrderServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("orderService")
@Transactional
public class OrderServiceImpl extends CommonServiceImpl implements OrderServiceI {
	
}