package com.sht.service.impl.question;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.question.QuestionServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("questionService")
@Transactional
public class QuestionServiceImpl extends CommonServiceImpl implements QuestionServiceI {
	
}