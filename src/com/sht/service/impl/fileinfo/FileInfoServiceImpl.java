package com.sht.service.impl.fileinfo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.fileinfo.FileInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("fileInfoService")
@Transactional
public class FileInfoServiceImpl extends CommonServiceImpl implements FileInfoServiceI {
	
}