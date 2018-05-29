package com.sht.service.impl.questiontag;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.questiontag.QuestionTagServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("questionTagService")
@Transactional
public class QuestionTagServiceImpl extends CommonServiceImpl implements QuestionTagServiceI {
	
}