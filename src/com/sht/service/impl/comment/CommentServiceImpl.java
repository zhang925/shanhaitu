package com.sht.service.impl.comment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sht.service.comment.CommentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("commentService")
@Transactional
public class CommentServiceImpl extends CommonServiceImpl implements CommentServiceI {
	
}