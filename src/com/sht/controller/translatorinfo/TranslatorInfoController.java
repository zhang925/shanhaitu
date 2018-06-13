package com.sht.controller.translatorinfo;
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

import com.sht.entity.translatorinfo.TranslatorInfoEntity;
import com.sht.service.translatorinfo.TranslatorInfoServiceI;

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
 * @Description: 翻译人员信息
 * @author zhangdaihao
 * @date 2018-06-13 17:01:33
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/translatorInfoController")
public class TranslatorInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TranslatorInfoController.class);

	@Autowired
	private TranslatorInfoServiceI translatorInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 翻译人员信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/translatorinfo/translatorInfoList");
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
	public void datagrid(TranslatorInfoEntity translatorInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TranslatorInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, translatorInfo, request.getParameterMap());
		this.translatorInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除翻译人员信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TranslatorInfoEntity translatorInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		translatorInfo = systemService.getEntity(TranslatorInfoEntity.class, translatorInfo.getId());
		message = "翻译人员信息删除成功";
		translatorInfoService.delete(translatorInfo);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加翻译人员信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TranslatorInfoEntity translatorInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(translatorInfo.getId())) {
			message = "翻译人员信息更新成功";
			TranslatorInfoEntity t = translatorInfoService.get(TranslatorInfoEntity.class, translatorInfo.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(translatorInfo, t);
				translatorInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "翻译人员信息更新失败";
			}
		} else {
			message = "翻译人员信息添加成功";
			translatorInfoService.save(translatorInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 翻译人员信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TranslatorInfoEntity translatorInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(translatorInfo.getId())) {
			translatorInfo = translatorInfoService.getEntity(TranslatorInfoEntity.class, translatorInfo.getId());
			req.setAttribute("translatorInfoPage", translatorInfo);
		}
		return new ModelAndView("sht/translatorinfo/translatorInfo");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<TranslatorInfoEntity> list() {
		List<TranslatorInfoEntity> listTranslatorInfos=translatorInfoService.getList(TranslatorInfoEntity.class);
		return listTranslatorInfos;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		TranslatorInfoEntity task = translatorInfoService.get(TranslatorInfoEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TranslatorInfoEntity translatorInfo, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TranslatorInfoEntity>> failures = validator.validate(translatorInfo);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		translatorInfoService.save(translatorInfo);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = translatorInfo.getId();
		URI uri = uriBuilder.path("/rest/translatorInfoController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TranslatorInfoEntity translatorInfo) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TranslatorInfoEntity>> failures = validator.validate(translatorInfo);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		translatorInfoService.saveOrUpdate(translatorInfo);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		translatorInfoService.deleteEntityById(TranslatorInfoEntity.class, id);
	}
}
