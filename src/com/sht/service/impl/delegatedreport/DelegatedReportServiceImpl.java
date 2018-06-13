package com.sht.service.impl.delegatedreport;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.delegatedreport.DelegatedReportServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("delegatedReportService")
@Transactional
public class DelegatedReportServiceImpl extends CommonServiceImpl implements DelegatedReportServiceI {
	
}