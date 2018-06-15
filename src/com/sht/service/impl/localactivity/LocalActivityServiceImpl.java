package com.sht.service.impl.localactivity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.localactivity.LocalActivityServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("localActivityService")
@Transactional
public class LocalActivityServiceImpl extends CommonServiceImpl implements LocalActivityServiceI {
	
}