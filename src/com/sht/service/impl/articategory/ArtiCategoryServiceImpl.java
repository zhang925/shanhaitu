package com.sht.service.impl.articategory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.articategory.ArtiCategoryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("artiCategoryService")
@Transactional
public class ArtiCategoryServiceImpl extends CommonServiceImpl implements ArtiCategoryServiceI {
	
}