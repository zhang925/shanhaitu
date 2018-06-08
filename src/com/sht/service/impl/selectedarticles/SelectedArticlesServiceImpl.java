package com.sht.service.impl.selectedarticles;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.selectedarticles.SelectedArticlesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("selectedArticlesService")
@Transactional
public class SelectedArticlesServiceImpl extends CommonServiceImpl implements SelectedArticlesServiceI {
	
}