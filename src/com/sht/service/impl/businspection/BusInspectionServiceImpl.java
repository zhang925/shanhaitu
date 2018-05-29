package com.sht.service.impl.businspection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.businspection.BusInspectionServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("busInspectionService")
@Transactional
public class BusInspectionServiceImpl extends CommonServiceImpl implements BusInspectionServiceI {
	
}