package com.sht.service.impl.cooperationprod;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.cooperationprod.CooperationProdServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("cooperationProdService")
@Transactional
public class CooperationProdServiceImpl extends CommonServiceImpl implements CooperationProdServiceI {
	
}