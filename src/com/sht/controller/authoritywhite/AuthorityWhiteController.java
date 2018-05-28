package com.sht.controller.authoritywhite;
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

import com.sht.entity.authoritywhite.AuthorityWhiteEntity;
import com.sht.service.authoritywhite.AuthorityWhiteServiceI;

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
 * @Description: 请求过滤白名单
 * @author zhangdaihao
 * @date 2018-05-26 19:43:38
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/authorityWhiteController")
public class AuthorityWhiteController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AuthorityWhiteController.class);

	@Autowired
	private AuthorityWhiteServiceI authorityWhiteService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 请求过滤白名单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/authoritywhite/authorityWhiteList");
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
	public void datagrid(AuthorityWhiteEntity authorityWhite,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AuthorityWhiteEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, authorityWhite, request.getParameterMap());
		this.authorityWhiteService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除请求过滤白名单
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(AuthorityWhiteEntity authorityWhite, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		authorityWhite = systemService.getEntity(AuthorityWhiteEntity.class, authorityWhite.getId());
		message = "请求过滤白名单删除成功";
		authorityWhiteService.delete(authorityWhite);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加请求过滤白名单
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(AuthorityWhiteEntity authorityWhite, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(authorityWhite.getId())) {
			message = "请求过滤白名单更新成功";
			AuthorityWhiteEntity t = authorityWhiteService.get(AuthorityWhiteEntity.class, authorityWhite.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(authorityWhite, t);
				authorityWhiteService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "请求过滤白名单更新失败";
			}
		} else {
			message = "请求过滤白名单添加成功";
			authorityWhiteService.save(authorityWhite);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 请求过滤白名单列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(AuthorityWhiteEntity authorityWhite, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(authorityWhite.getId())) {
			authorityWhite = authorityWhiteService.getEntity(AuthorityWhiteEntity.class, authorityWhite.getId());
			req.setAttribute("authorityWhitePage", authorityWhite);
		}
		return new ModelAndView("sht/authoritywhite/authorityWhite");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<AuthorityWhiteEntity> list() {
		List<AuthorityWhiteEntity> listAuthorityWhites=authorityWhiteService.getList(AuthorityWhiteEntity.class);
		return listAuthorityWhites;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AuthorityWhiteEntity task = authorityWhiteService.get(AuthorityWhiteEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AuthorityWhiteEntity authorityWhite, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AuthorityWhiteEntity>> failures = validator.validate(authorityWhite);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		authorityWhiteService.save(authorityWhite);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = authorityWhite.getId();
		URI uri = uriBuilder.path("/rest/authorityWhiteController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AuthorityWhiteEntity authorityWhite) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AuthorityWhiteEntity>> failures = validator.validate(authorityWhite);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		authorityWhiteService.saveOrUpdate(authorityWhite);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		authorityWhiteService.deleteEntityById(AuthorityWhiteEntity.class, id);
	}
}
