package com.sht.service.impl.questioncategory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.questioncategory.QuestionCategoryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("questionCategoryService")
@Transactional
public class QuestionCategoryServiceImpl extends CommonServiceImpl implements QuestionCategoryServiceI {
	
}