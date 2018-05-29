package com.sht.service.impl.hotarticle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.hotarticle.HotArticleServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("hotArticleService")
@Transactional
public class HotArticleServiceImpl extends CommonServiceImpl implements HotArticleServiceI {
	
}