package com.sht.service.impl.activityapply;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.activityapply.ActivityApplyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("activityApplyService")
@Transactional
public class ActivityApplyServiceImpl extends CommonServiceImpl implements ActivityApplyServiceI {
	
}