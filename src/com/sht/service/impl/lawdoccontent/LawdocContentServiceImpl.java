package com.sht.service.impl.lawdoccontent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.lawdoccontent.LawdocContentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("lawdocContentService")
@Transactional
public class LawdocContentServiceImpl extends CommonServiceImpl implements LawdocContentServiceI {
	
}