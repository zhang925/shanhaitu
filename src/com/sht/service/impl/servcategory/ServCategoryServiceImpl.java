package com.sht.service.impl.servcategory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.servcategory.ServCategoryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("servCategoryService")
@Transactional
public class ServCategoryServiceImpl extends CommonServiceImpl implements ServCategoryServiceI {
	
}