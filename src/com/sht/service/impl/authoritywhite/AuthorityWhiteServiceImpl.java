package com.sht.service.impl.authoritywhite;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.authoritywhite.AuthorityWhiteServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("authorityWhiteService")
@Transactional
public class AuthorityWhiteServiceImpl extends CommonServiceImpl implements AuthorityWhiteServiceI {
	
}