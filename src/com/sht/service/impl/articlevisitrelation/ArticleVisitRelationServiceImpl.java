package com.sht.service.impl.articlevisitrelation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.articlevisitrelation.ArticleVisitRelationServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("articleVisitRelationService")
@Transactional
public class ArticleVisitRelationServiceImpl extends CommonServiceImpl implements ArticleVisitRelationServiceI {
	
}