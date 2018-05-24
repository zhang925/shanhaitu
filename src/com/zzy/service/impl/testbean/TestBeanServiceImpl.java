package com.zzy.service.impl.testbean;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.service.testbean.TestBeanServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("testBeanService")
@Transactional
public class TestBeanServiceImpl extends CommonServiceImpl implements TestBeanServiceI {
	
}