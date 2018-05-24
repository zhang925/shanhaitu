package com.zzy.service.impl.classic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.service.classic.ClassicServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("classicService")
@Transactional
public class ClassicServiceImpl extends CommonServiceImpl implements ClassicServiceI {
	
}