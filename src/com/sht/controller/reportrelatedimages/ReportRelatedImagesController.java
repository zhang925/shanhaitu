package com.sht.controller.reportrelatedimages;
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

import com.sht.entity.reportrelatedimages.ReportRelatedImagesEntity;
import com.sht.service.reportrelatedimages.ReportRelatedImagesServiceI;

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
 * @Description: 调研报告相关图集
 * @author zhangdaihao
 * @date 2018-06-13 17:02:48
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/reportRelatedImagesController")
public class ReportRelatedImagesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReportRelatedImagesController.class);

	@Autowired
	private ReportRelatedImagesServiceI reportRelatedImagesService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 调研报告相关图集列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/reportrelatedimages/reportRelatedImagesList");
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
	public void datagrid(ReportRelatedImagesEntity reportRelatedImages,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ReportRelatedImagesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, reportRelatedImages, request.getParameterMap());
		this.reportRelatedImagesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除调研报告相关图集
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ReportRelatedImagesEntity reportRelatedImages, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		reportRelatedImages = systemService.getEntity(ReportRelatedImagesEntity.class, reportRelatedImages.getId());
		message = "调研报告相关图集删除成功";
		reportRelatedImagesService.delete(reportRelatedImages);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加调研报告相关图集
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ReportRelatedImagesEntity reportRelatedImages, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(reportRelatedImages.getId())) {
			message = "调研报告相关图集更新成功";
			ReportRelatedImagesEntity t = reportRelatedImagesService.get(ReportRelatedImagesEntity.class, reportRelatedImages.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(reportRelatedImages, t);
				reportRelatedImagesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "调研报告相关图集更新失败";
			}
		} else {
			message = "调研报告相关图集添加成功";
			reportRelatedImagesService.save(reportRelatedImages);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 调研报告相关图集列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ReportRelatedImagesEntity reportRelatedImages, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(reportRelatedImages.getId())) {
			reportRelatedImages = reportRelatedImagesService.getEntity(ReportRelatedImagesEntity.class, reportRelatedImages.getId());
			req.setAttribute("reportRelatedImagesPage", reportRelatedImages);
		}
		return new ModelAndView("sht/reportrelatedimages/reportRelatedImages");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ReportRelatedImagesEntity> list() {
		List<ReportRelatedImagesEntity> listReportRelatedImagess=reportRelatedImagesService.getList(ReportRelatedImagesEntity.class);
		return listReportRelatedImagess;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		ReportRelatedImagesEntity task = reportRelatedImagesService.get(ReportRelatedImagesEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody ReportRelatedImagesEntity reportRelatedImages, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReportRelatedImagesEntity>> failures = validator.validate(reportRelatedImages);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		reportRelatedImagesService.save(reportRelatedImages);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = reportRelatedImages.getId();
		URI uri = uriBuilder.path("/rest/reportRelatedImagesController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ReportRelatedImagesEntity reportRelatedImages) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReportRelatedImagesEntity>> failures = validator.validate(reportRelatedImages);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		reportRelatedImagesService.saveOrUpdate(reportRelatedImages);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		reportRelatedImagesService.deleteEntityById(ReportRelatedImagesEntity.class, id);
	}
}
