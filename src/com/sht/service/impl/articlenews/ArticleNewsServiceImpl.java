package com.sht.service.impl.articlenews;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.articlenews.ArticleNewsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("articleNewsService")
@Transactional
public class ArticleNewsServiceImpl extends CommonServiceImpl implements ArticleNewsServiceI {
	
}