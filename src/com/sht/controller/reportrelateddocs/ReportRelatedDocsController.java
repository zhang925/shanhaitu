package com.sht.controller.reportrelateddocs;
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

import com.sht.entity.reportrelateddocs.ReportRelatedDocsEntity;
import com.sht.service.reportrelateddocs.ReportRelatedDocsServiceI;

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
 * @Description: 调研报告相关资料
 * @author zhangdaihao
 * @date 2018-06-13 17:02:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/reportRelatedDocsController")
public class ReportRelatedDocsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReportRelatedDocsController.class);

	@Autowired
	private ReportRelatedDocsServiceI reportRelatedDocsService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 调研报告相关资料列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/reportrelateddocs/reportRelatedDocsList");
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
	public void datagrid(ReportRelatedDocsEntity reportRelatedDocs,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ReportRelatedDocsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, reportRelatedDocs, request.getParameterMap());
		this.reportRelatedDocsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除调研报告相关资料
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ReportRelatedDocsEntity reportRelatedDocs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		reportRelatedDocs = systemService.getEntity(ReportRelatedDocsEntity.class, reportRelatedDocs.getId());
		message = "调研报告相关资料删除成功";
		reportRelatedDocsService.delete(reportRelatedDocs);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加调研报告相关资料
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ReportRelatedDocsEntity reportRelatedDocs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(reportRelatedDocs.getId())) {
			message = "调研报告相关资料更新成功";
			ReportRelatedDocsEntity t = reportRelatedDocsService.get(ReportRelatedDocsEntity.class, reportRelatedDocs.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(reportRelatedDocs, t);
				reportRelatedDocsService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "调研报告相关资料更新失败";
			}
		} else {
			message = "调研报告相关资料添加成功";
			reportRelatedDocsService.save(reportRelatedDocs);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 调研报告相关资料列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ReportRelatedDocsEntity reportRelatedDocs, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(reportRelatedDocs.getId())) {
			reportRelatedDocs = reportRelatedDocsService.getEntity(ReportRelatedDocsEntity.class, reportRelatedDocs.getId());
			req.setAttribute("reportRelatedDocsPage", reportRelatedDocs);
		}
		return new ModelAndView("sht/reportrelateddocs/reportRelatedDocs");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ReportRelatedDocsEntity> list() {
		List<ReportRelatedDocsEntity> listReportRelatedDocss=reportRelatedDocsService.getList(ReportRelatedDocsEntity.class);
		return listReportRelatedDocss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		ReportRelatedDocsEntity task = reportRelatedDocsService.get(ReportRelatedDocsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody ReportRelatedDocsEntity reportRelatedDocs, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReportRelatedDocsEntity>> failures = validator.validate(reportRelatedDocs);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		reportRelatedDocsService.save(reportRelatedDocs);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = reportRelatedDocs.getId();
		URI uri = uriBuilder.path("/rest/reportRelatedDocsController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ReportRelatedDocsEntity reportRelatedDocs) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReportRelatedDocsEntity>> failures = validator.validate(reportRelatedDocs);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		reportRelatedDocsService.saveOrUpdate(reportRelatedDocs);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		reportRelatedDocsService.deleteEntityById(ReportRelatedDocsEntity.class, id);
	}
}
