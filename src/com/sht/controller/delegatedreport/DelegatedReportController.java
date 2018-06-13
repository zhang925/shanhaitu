package com.sht.controller.delegatedreport;
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

import com.sht.entity.delegatedreport.DelegatedReportEntity;
import com.sht.service.delegatedreport.DelegatedReportServiceI;

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
 * @Description: 委托调研报告表
 * @author zhangdaihao
 * @date 2018-06-13 17:00:45
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/delegatedReportController")
public class DelegatedReportController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DelegatedReportController.class);

	@Autowired
	private DelegatedReportServiceI delegatedReportService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 委托调研报告表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/delegatedreport/delegatedReportList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DelegatedReportEntity delegatedReport,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DelegatedReportEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, delegatedReport, request.getParameterMap());
		this.delegatedReportService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除委托调研报告表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(DelegatedReportEntity delegatedReport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		delegatedReport = systemService.getEntity(DelegatedReportEntity.class, delegatedReport.getId());
		message = "委托调研报告表删除成功";
		delegatedReportService.delete(delegatedReport);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加委托调研报告表
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(DelegatedReportEntity delegatedReport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(delegatedReport.getId())) {
			message = "委托调研报告表更新成功";
			DelegatedReportEntity t = delegatedReportService.get(DelegatedReportEntity.class, delegatedReport.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(delegatedReport, t);
				delegatedReportService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "委托调研报告表更新失败";
			}
		} else {
			message = "委托调研报告表添加成功";
			delegatedReportService.save(delegatedReport);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 委托调研报告表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(DelegatedReportEntity delegatedReport, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(delegatedReport.getId())) {
			delegatedReport = delegatedReportService.getEntity(DelegatedReportEntity.class, delegatedReport.getId());
			req.setAttribute("delegatedReportPage", delegatedReport);
		}
		return new ModelAndView("sht/delegatedreport/delegatedReport");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<DelegatedReportEntity> list() {
		List<DelegatedReportEntity> listDelegatedReports=delegatedReportService.getList(DelegatedReportEntity.class);
		return listDelegatedReports;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DelegatedReportEntity task = delegatedReportService.get(DelegatedReportEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DelegatedReportEntity delegatedReport, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DelegatedReportEntity>> failures = validator.validate(delegatedReport);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		delegatedReportService.save(delegatedReport);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = delegatedReport.getId();
		URI uri = uriBuilder.path("/rest/delegatedReportController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DelegatedReportEntity delegatedReport) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DelegatedReportEntity>> failures = validator.validate(delegatedReport);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		delegatedReportService.saveOrUpdate(delegatedReport);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		delegatedReportService.deleteEntityById(DelegatedReportEntity.class, id);
	}
}
