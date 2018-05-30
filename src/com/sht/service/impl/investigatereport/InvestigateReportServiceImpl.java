package com.sht.service.impl.investigatereport;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.investigatereport.InvestigateReportServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("investigateReportService")
@Transactional
public class InvestigateReportServiceImpl extends CommonServiceImpl implements InvestigateReportServiceI {
	
}