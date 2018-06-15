package com.sht.service.impl.activitydocs;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.activitydocs.ActivityDocsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("activityDocsService")
@Transactional
public class ActivityDocsServiceImpl extends CommonServiceImpl implements ActivityDocsServiceI {
	
}