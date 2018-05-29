package com.sht.service.impl.questionrelationtag;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.questionrelationtag.QuestionRelationTagServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("questionRelationTagService")
@Transactional
public class QuestionRelationTagServiceImpl extends CommonServiceImpl implements QuestionRelationTagServiceI {
	
}