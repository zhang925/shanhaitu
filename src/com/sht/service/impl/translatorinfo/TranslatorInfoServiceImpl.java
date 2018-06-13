package com.sht.service.impl.translatorinfo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.translatorinfo.TranslatorInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("translatorInfoService")
@Transactional
public class TranslatorInfoServiceImpl extends CommonServiceImpl implements TranslatorInfoServiceI {
	
}