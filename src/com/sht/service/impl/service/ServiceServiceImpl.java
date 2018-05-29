package com.sht.service.impl.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.service.ServiceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("serviceService")
@Transactional
public class ServiceServiceImpl extends CommonServiceImpl implements ServiceServiceI {
	
}