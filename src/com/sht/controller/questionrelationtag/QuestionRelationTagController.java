package com.sht.controller.questionrelationtag;
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

import com.sht.entity.questionrelationtag.QuestionRelationTagEntity;
import com.sht.service.questionrelationtag.QuestionRelationTagServiceI;

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
 * @Description: 问题分类和问题关系表
 * @author zhangdaihao
 * @date 2018-06-10 20:22:00
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/questionRelationTagController")
public class QuestionRelationTagController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(QuestionRelationTagController.class);

	@Autowired
	private QuestionRelationTagServiceI questionRelationTagService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 问题分类和问题关系表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/questionrelationtag/questionRelationTagList");
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
	public void datagrid(QuestionRelationTagEntity questionRelationTag,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(QuestionRelationTagEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, questionRelationTag, request.getParameterMap());
		this.questionRelationTagService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除问题分类和问题关系表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(QuestionRelationTagEntity questionRelationTag, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		questionRelationTag = systemService.getEntity(QuestionRelationTagEntity.class, questionRelationTag.getId());
		message = "问题分类和问题关系表删除成功";
		questionRelationTagService.delete(questionRelationTag);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加问题分类和问题关系表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(QuestionRelationTagEntity questionRelationTag, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(questionRelationTag.getId())) {
			message = "问题分类和问题关系表更新成功";
			QuestionRelationTagEntity t = questionRelationTagService.get(QuestionRelationTagEntity.class, questionRelationTag.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(questionRelationTag, t);
				questionRelationTagService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "问题分类和问题关系表更新失败";
			}
		} else {
			message = "问题分类和问题关系表添加成功";
			questionRelationTagService.save(questionRelationTag);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 问题分类和问题关系表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(QuestionRelationTagEntity questionRelationTag, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(questionRelationTag.getId())) {
			questionRelationTag = questionRelationTagService.getEntity(QuestionRelationTagEntity.class, questionRelationTag.getId());
			req.setAttribute("questionRelationTagPage", questionRelationTag);
		}
		return new ModelAndView("sht/questionrelationtag/questionRelationTag");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<QuestionRelationTagEntity> list() {
		List<QuestionRelationTagEntity> listQuestionRelationTags=questionRelationTagService.getList(QuestionRelationTagEntity.class);
		return listQuestionRelationTags;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		QuestionRelationTagEntity task = questionRelationTagService.get(QuestionRelationTagEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody QuestionRelationTagEntity questionRelationTag, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<QuestionRelationTagEntity>> failures = validator.validate(questionRelationTag);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		questionRelationTagService.save(questionRelationTag);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = questionRelationTag.getId();
		URI uri = uriBuilder.path("/rest/questionRelationTagController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody QuestionRelationTagEntity questionRelationTag) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<QuestionRelationTagEntity>> failures = validator.validate(questionRelationTag);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		questionRelationTagService.saveOrUpdate(questionRelationTag);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		questionRelationTagService.deleteEntityById(QuestionRelationTagEntity.class, id);
	}
}
