package com.sht.service.impl.activitypictures;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.activitypictures.ActivityPicturesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("activityPicturesService")
@Transactional
public class ActivityPicturesServiceImpl extends CommonServiceImpl implements ActivityPicturesServiceI {
	
}