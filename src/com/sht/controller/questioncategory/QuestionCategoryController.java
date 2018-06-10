package com.sht.controller.questioncategory;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.oConvertUtils;
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

import com.sht.entity.questioncategory.QuestionCategoryEntity;
import com.sht.service.questioncategory.QuestionCategoryServiceI;

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
 * @Description: 问题分类表
 * @author zhangdaihao
 * @date 2018-05-29 22:02:19
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/questionCategoryController")
public class QuestionCategoryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(QuestionCategoryController.class);

	@Autowired
	private QuestionCategoryServiceI questionCategoryService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 问题分类表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/questioncategory/questionCategoryList");
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
	public void datagrid(QuestionCategoryEntity questionCategory,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(QuestionCategoryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, questionCategory, request.getParameterMap());
		this.questionCategoryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除问题分类表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(QuestionCategoryEntity questionCategory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		questionCategory = systemService.getEntity(QuestionCategoryEntity.class, questionCategory.getId());
		message = "问题分类表删除成功";
		questionCategoryService.delete(questionCategory);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加问题分类表
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(QuestionCategoryEntity questionCategory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(questionCategory.getId())) {
			message = "问题分类表更新成功";
			QuestionCategoryEntity t = questionCategoryService.get(QuestionCategoryEntity.class, questionCategory.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(questionCategory, t);
				questionCategoryService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "问题分类表更新失败";
			}
		} else {
			message = "问题分类表添加成功";
			questionCategoryService.save(questionCategory);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 问题分类表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(QuestionCategoryEntity questionCategory, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(questionCategory.getId())) {
			questionCategory = questionCategoryService.getEntity(QuestionCategoryEntity.class, questionCategory.getId());
			req.setAttribute("questionCategoryPage", questionCategory);
		}
		return new ModelAndView("sht/questioncategory/questionCategory");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<QuestionCategoryEntity> list() {
		List<QuestionCategoryEntity> listQuestionCategorys=questionCategoryService.getList(QuestionCategoryEntity.class);
		return listQuestionCategorys;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		QuestionCategoryEntity task = questionCategoryService.get(QuestionCategoryEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody QuestionCategoryEntity questionCategory, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<QuestionCategoryEntity>> failures = validator.validate(questionCategory);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		questionCategoryService.save(questionCategory);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = questionCategory.getId();
		URI uri = uriBuilder.path("/rest/questionCategoryController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody QuestionCategoryEntity questionCategory) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<QuestionCategoryEntity>> failures = validator.validate(questionCategory);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		questionCategoryService.saveOrUpdate(questionCategory);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		questionCategoryService.deleteEntityById(QuestionCategoryEntity.class, id);
	}
}
