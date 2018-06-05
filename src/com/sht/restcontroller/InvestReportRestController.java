package com.sht.restcontroller;

import com.sht.entity.articlenews.ArticleNewsEntity;
import com.sht.entity.investigatereport.InvestigateReportEntity;
import com.sht.restcontroller.tempentity.AjaxMsg;
import com.sht.service.investigatereport.InvestigateReportServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**   
 * @Title: Controller
 * @Description: 调研报告
 * @author zhangdaihao
 * @date 2018-05-29 21:50:25
 * @version V1.0   
 *
 */
@RestController
@RequestMapping("/investReport")
public class InvestReportRestController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(InvestReportRestController.class);

	@Autowired
	private InvestigateReportServiceI investigateReportService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	



	/**
	 * 调研报告列表
	 *
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public AjaxMsg list(InvestigateReportEntity investigateReportEntity, HttpServletResponse response, HttpServletRequest request){
		AjaxMsg ajaxMsg = new AjaxMsg();
		List<InvestigateReportEntity> list;
		list = investigateReportService.getList(ArticleNewsEntity.class);
		ajaxMsg.setMsg("success");
		ajaxMsg.setResponsecode(HttpStatus.OK.value());
		ajaxMsg.setModel(list);
		return ajaxMsg;
	}

}
