package com.sht.controller.lawdoccatalog;
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

import com.sht.entity.lawdoccatalog.LawdocCatalogEntity;
import com.sht.service.lawdoccatalog.LawdocCatalogServiceI;

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
 * @Description: 政策法规目录
 * @author zhangdaihao
 * @date 2018-06-15 11:56:48
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/lawdocCatalogController")
public class LawdocCatalogController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LawdocCatalogController.class);

	@Autowired
	private LawdocCatalogServiceI lawdocCatalogService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 政策法规目录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/lawdoccatalog/lawdocCatalogList");
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
	public void datagrid(LawdocCatalogEntity lawdocCatalog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//强制排序
		dataGrid.setSort("orders");
		dataGrid.setOrder("asc");
		CriteriaQuery cq = new CriteriaQuery(LawdocCatalogEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, lawdocCatalog, request.getParameterMap());
		this.lawdocCatalogService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除政策法规目录
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(LawdocCatalogEntity lawdocCatalog, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		lawdocCatalog = systemService.getEntity(LawdocCatalogEntity.class, lawdocCatalog.getId());
		message = "政策法规目录删除成功";
		lawdocCatalogService.delete(lawdocCatalog);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加政策法规目录
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(LawdocCatalogEntity lawdocCatalog, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(lawdocCatalog.getId())) {
			message = "政策法规目录更新成功";
			LawdocCatalogEntity t = lawdocCatalogService.get(LawdocCatalogEntity.class, lawdocCatalog.getId());
			try {
				double oldOrder = t.getOrders();//放到前面获取，不然后覆盖
				double newOrder =  lawdocCatalog.getOrders();
				MyBeanUtils.copyBeanNotNull2Bean(lawdocCatalog, t);
				lawdocCatalogService.saveOrUpdate(t);
				//一定要保存后重新排序。
				softOrder( oldOrder, newOrder);//重新排序
				//systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "政策法规目录更新失败";
			}
		} else {
			message = "政策法规目录添加成功";
			lawdocCatalogService.save(lawdocCatalog);
			//一定要保存后重新排序。
			softOrder( -1,  lawdocCatalog.getOrders());//重新排序
			//systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 政策法规目录列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(LawdocCatalogEntity lawdocCatalog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(lawdocCatalog.getId())) {
			lawdocCatalog = lawdocCatalogService.getEntity(LawdocCatalogEntity.class, lawdocCatalog.getId());
			req.setAttribute("lawdocCatalogPage", lawdocCatalog);
		}
		return new ModelAndView("sht/lawdoccatalog/lawdocCatalog");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<LawdocCatalogEntity> list() {
		List<LawdocCatalogEntity> listLawdocCatalogs=lawdocCatalogService.getList(LawdocCatalogEntity.class);
		return listLawdocCatalogs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		LawdocCatalogEntity task = lawdocCatalogService.get(LawdocCatalogEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody LawdocCatalogEntity lawdocCatalog, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<LawdocCatalogEntity>> failures = validator.validate(lawdocCatalog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		lawdocCatalogService.save(lawdocCatalog);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = lawdocCatalog.getId();
		URI uri = uriBuilder.path("/rest/lawdocCatalogController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody LawdocCatalogEntity lawdocCatalog) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<LawdocCatalogEntity>> failures = validator.validate(lawdocCatalog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		lawdocCatalogService.saveOrUpdate(lawdocCatalog);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		lawdocCatalogService.deleteEntityById(LawdocCatalogEntity.class, id);
	}


	/**
	 *
	 * 添加修改的时候重新 排序，其他不用管
	 * @param oldOrder 旧的序号，-1 表示添加
	 * @param newOrder 新的序号
	 */
	public  void softOrder(double oldOrder,double newOrder){
		if(oldOrder == newOrder){//没有改。
			return;
		}
		List<LawdocCatalogEntity> list =  systemService.findHql(" from LawdocCatalogEntity as a ORDER BY a.orders ASC ",null);

		if(list!=null && list.size()>0){//这种是全部排序最简单，后期数据量大的情况下，在优化。
			//更新数据库
			//判段从哪个地方 更改的
			if(newOrder<=list.size()){
				double temp = 0;
				if(oldOrder==-1){//说明是 添加,并且是往前面排序
					temp = newOrder;
				}else{
					temp = ( newOrder <= oldOrder )? newOrder : oldOrder;//新旧排序，谁小取谁
					if(temp<0){//用户填了个负数
						temp =0;//认为是第一位
					}
				}
				for(double i=temp;i<list.size();i++){//比较消耗系统资源，但是没有办法
					LawdocCatalogEntity model = list.get((int)i);
					model.setOrders((int)i+1);
					systemService.updateEntitie(model);
				}
			}


		}
	}
}
