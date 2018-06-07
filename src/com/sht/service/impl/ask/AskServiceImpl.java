package com.sht.service.impl.ask;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.ask.AskServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("askService")
@Transactional
public class AskServiceImpl extends CommonServiceImpl implements AskServiceI {
	
}