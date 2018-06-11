package com.sht.controller.articategory;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.tag.vo.datatable.SortDirection;
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

import com.sht.entity.articategory.ArtiCategoryEntity;
import com.sht.service.articategory.ArtiCategoryServiceI;

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

import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 文章分类
 * @author zhangdaihao
 * @date 2018-05-29 21:56:46
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/artiCategoryController")
public class ArtiCategoryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ArtiCategoryController.class);

	@Autowired
	private ArtiCategoryServiceI artiCategoryService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 文章分类列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/articategory/artiCategoryList");
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
	public void datagrid(ArtiCategoryEntity artiCategory,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//强制排序
		dataGrid.setSort("orders");
		dataGrid.setOrder("asc");
		CriteriaQuery cq = new CriteriaQuery(ArtiCategoryEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, artiCategory, request.getParameterMap());
		this.artiCategoryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除文章分类
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ArtiCategoryEntity artiCategory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		artiCategory = systemService.getEntity(ArtiCategoryEntity.class, artiCategory.getId());
		message = "文章分类删除成功";
		artiCategoryService.delete(artiCategory);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加文章分类
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ArtiCategoryEntity artiCategory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(artiCategory.getId())) {
			message = "文章分类更新成功";
			ArtiCategoryEntity t = artiCategoryService.get(ArtiCategoryEntity.class, artiCategory.getId());
			try {
				double oldOrder = t.getOrders();//放到前面获取，不然后覆盖
				double newOrder =  artiCategory.getOrders();
				MyBeanUtils.copyBeanNotNull2Bean(artiCategory, t);
				artiCategoryService.saveOrUpdate(t);
				//一定要保存后重新排序。
				softOrder( oldOrder, newOrder);//重新排序
				//systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "文章分类更新失败";
			}
		} else {
			message = "文章分类添加成功";
			artiCategoryService.save(artiCategory);
			softOrder( -1, artiCategory.getOrders());//重新排序
			//systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 文章分类列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ArtiCategoryEntity artiCategory, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(artiCategory.getId())) {
			artiCategory = artiCategoryService.getEntity(ArtiCategoryEntity.class, artiCategory.getId());
			req.setAttribute("artiCategoryPage", artiCategory);
		}
		return new ModelAndView("sht/articategory/artiCategory");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ArtiCategoryEntity> list() {
		List<ArtiCategoryEntity> listArtiCategorys=artiCategoryService.getList(ArtiCategoryEntity.class);
		return listArtiCategorys;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		ArtiCategoryEntity task = artiCategoryService.get(ArtiCategoryEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody ArtiCategoryEntity artiCategory, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ArtiCategoryEntity>> failures = validator.validate(artiCategory);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		artiCategoryService.save(artiCategory);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = artiCategory.getId();
		URI uri = uriBuilder.path("/rest/artiCategoryController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ArtiCategoryEntity artiCategory) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ArtiCategoryEntity>> failures = validator.validate(artiCategory);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		artiCategoryService.saveOrUpdate(artiCategory);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		artiCategoryService.deleteEntityById(ArtiCategoryEntity.class, id);
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
		List<ArtiCategoryEntity> list =  systemService.findHql(" from ArtiCategoryEntity as a ORDER BY a.orders ASC ",null);

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
					ArtiCategoryEntity model = list.get((int)i);
					model.setOrders((int)i+1);
					systemService.updateEntitie(model);
				}
			}


		}
	}


}
