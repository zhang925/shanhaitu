package com.zzy.service.impl.snotice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.service.snotice.SnoticeServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("snoticeService")
@Transactional
public class SnoticeServiceImpl extends CommonServiceImpl implements SnoticeServiceI {
	
}