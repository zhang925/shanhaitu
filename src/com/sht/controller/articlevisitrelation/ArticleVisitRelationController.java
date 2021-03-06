package com.sht.controller.articlevisitrelation;
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

import com.sht.entity.articlevisitrelation.ArticleVisitRelationEntity;
import com.sht.service.articlevisitrelation.ArticleVisitRelationServiceI;

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
 * @Description: 文章访问渠道
 * @author zhangdaihao
 * @date 2018-05-29 21:55:42
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/articleVisitRelationController")
public class ArticleVisitRelationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ArticleVisitRelationController.class);

	@Autowired
	private ArticleVisitRelationServiceI articleVisitRelationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 文章访问渠道列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/articlevisitrelation/articleVisitRelationList");
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
	public void datagrid(ArticleVisitRelationEntity articleVisitRelation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ArticleVisitRelationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, articleVisitRelation, request.getParameterMap());
		this.articleVisitRelationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除文章访问渠道
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ArticleVisitRelationEntity articleVisitRelation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		articleVisitRelation = systemService.getEntity(ArticleVisitRelationEntity.class, articleVisitRelation.getId());
		message = "文章访问渠道删除成功";
		articleVisitRelationService.delete(articleVisitRelation);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加文章访问渠道
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ArticleVisitRelationEntity articleVisitRelation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(articleVisitRelation.getId())) {
			message = "文章访问渠道更新成功";
			ArticleVisitRelationEntity t = articleVisitRelationService.get(ArticleVisitRelationEntity.class, articleVisitRelation.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(articleVisitRelation, t);
				articleVisitRelationService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "文章访问渠道更新失败";
			}
		} else {
			message = "文章访问渠道添加成功";
			articleVisitRelationService.save(articleVisitRelation);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 文章访问渠道列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ArticleVisitRelationEntity articleVisitRelation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(articleVisitRelation.getId())) {
			articleVisitRelation = articleVisitRelationService.getEntity(ArticleVisitRelationEntity.class, articleVisitRelation.getId());
			req.setAttribute("articleVisitRelationPage", articleVisitRelation);
		}
		return new ModelAndView("sht/articlevisitrelation/articleVisitRelation");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ArticleVisitRelationEntity> list() {
		List<ArticleVisitRelationEntity> listArticleVisitRelations=articleVisitRelationService.getList(ArticleVisitRelationEntity.class);
		return listArticleVisitRelations;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		ArticleVisitRelationEntity task = articleVisitRelationService.get(ArticleVisitRelationEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody ArticleVisitRelationEntity articleVisitRelation, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ArticleVisitRelationEntity>> failures = validator.validate(articleVisitRelation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		articleVisitRelationService.save(articleVisitRelation);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = articleVisitRelation.getId();
		URI uri = uriBuilder.path("/rest/articleVisitRelationController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ArticleVisitRelationEntity articleVisitRelation) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ArticleVisitRelationEntity>> failures = validator.validate(articleVisitRelation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		articleVisitRelationService.saveOrUpdate(articleVisitRelation);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		articleVisitRelationService.deleteEntityById(ArticleVisitRelationEntity.class, id);
	}
}
