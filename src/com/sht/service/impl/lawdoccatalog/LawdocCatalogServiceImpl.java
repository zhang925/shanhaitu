package com.sht.service.impl.lawdoccatalog;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.lawdoccatalog.LawdocCatalogServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("lawdocCatalogService")
@Transactional
public class LawdocCatalogServiceImpl extends CommonServiceImpl implements LawdocCatalogServiceI {
	
}