package com.sht.service.impl.bustype;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.bustype.BusTypeServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("busTypeService")
@Transactional
public class BusTypeServiceImpl extends CommonServiceImpl implements BusTypeServiceI {
	
}