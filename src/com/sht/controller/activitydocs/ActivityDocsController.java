package com.sht.controller.activitydocs;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.sht.entity.activitydocs.ActivityDocsEntity;
import com.sht.service.activitydocs.ActivityDocsServiceI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 活动资料
 * @author zhangdaihao
 * @date 2018-06-15 11:06:13
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/activityDocsController")
public class ActivityDocsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ActivityDocsController.class);

	@Autowired
	private ActivityDocsServiceI activityDocsService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 活动资料列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/activitydocs/activityDocsList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ActivityDocsEntity activityDocs,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ActivityDocsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, activityDocs, request.getParameterMap());
		this.activityDocsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除活动资料
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ActivityDocsEntity activityDocs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		activityDocs = systemService.getEntity(ActivityDocsEntity.class, activityDocs.getId());
		message = "活动资料删除成功";
		activityDocsService.delete(activityDocs);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加活动资料
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ActivityDocsEntity activityDocs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(activityDocs.getId())) {
			message = "活动资料更新成功";
			ActivityDocsEntity t = activityDocsService.get(ActivityDocsEntity.class, activityDocs.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(activityDocs, t);
				activityDocsService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "活动资料更新失败";
			}
		} else {
			message = "活动资料添加成功";
			activityDocsService.save(activityDocs);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 活动资料列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ActivityDocsEntity activityDocs, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(activityDocs.getId())) {
			activityDocs = activityDocsService.getEntity(ActivityDocsEntity.class, activityDocs.getId());
			req.setAttribute("activityDocsPage", activityDocs);
		}
		return new ModelAndView("sht/activitydocs/activityDocs");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ActivityDocsEntity> list() {
		List<ActivityDocsEntity> listActivityDocss=activityDocsService.getList(ActivityDocsEntity.class);
		return listActivityDocss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		ActivityDocsEntity task = activityDocsService.get(ActivityDocsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody ActivityDocsEntity activityDocs, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ActivityDocsEntity>> failures = validator.validate(activityDocs);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		activityDocsService.save(activityDocs);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = activityDocs.getId();
		URI uri = uriBuilder.path("/rest/activityDocsController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ActivityDocsEntity activityDocs) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ActivityDocsEntity>> failures = validator.validate(activityDocs);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		activityDocsService.saveOrUpdate(activityDocs);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		activityDocsService.deleteEntityById(ActivityDocsEntity.class, id);
	}
}
