package com.sht.controller.cooperationprod;
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

import com.sht.entity.cooperationprod.CooperationProdEntity;
import com.sht.service.cooperationprod.CooperationProdServiceI;

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
 * @Description: 合作对接
 * @author zhangdaihao
 * @date 2018-06-15 11:00:53
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/cooperationProdController")
public class CooperationProdController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CooperationProdController.class);

	@Autowired
	private CooperationProdServiceI cooperationProdService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 合作对接列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("sht/cooperationprod/cooperationProdList");
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
	public void datagrid(CooperationProdEntity cooperationProd,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//强制排序
		dataGrid.setSort("orders");
		dataGrid.setOrder("asc");

		CriteriaQuery cq = new CriteriaQuery(CooperationProdEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, cooperationProd, request.getParameterMap());
		this.cooperationProdService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除合作对接
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(CooperationProdEntity cooperationProd, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		cooperationProd = systemService.getEntity(CooperationProdEntity.class, cooperationProd.getId());
		message = "合作对接删除成功";
		cooperationProdService.delete(cooperationProd);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加合作对接
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(CooperationProdEntity cooperationProd, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(cooperationProd.getId())) {
			message = "合作对接更新成功";
			CooperationProdEntity t = cooperationProdService.get(CooperationProdEntity.class, cooperationProd.getId());
			try {

				double oldOrder = t.getOrders();//放到前面获取，不然后覆盖
				double newOrder =  cooperationProd.getOrders();


				MyBeanUtils.copyBeanNotNull2Bean(cooperationProd, t);
				cooperationProdService.saveOrUpdate(t);

				//一定要保存后重新排序。
				softOrder( oldOrder, newOrder);//重新排序

				//systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "合作对接更新失败";
			}
		} else {
			message = "合作对接添加成功";
			cooperationProdService.save(cooperationProd);
			softOrder( -1, cooperationProd.getOrders());//重新排序

			//systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 合作对接列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(CooperationProdEntity cooperationProd, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(cooperationProd.getId())) {
			cooperationProd = cooperationProdService.getEntity(CooperationProdEntity.class, cooperationProd.getId());
			req.setAttribute("cooperationProdPage", cooperationProd);
		}
		return new ModelAndView("sht/cooperationprod/cooperationProd");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<CooperationProdEntity> list() {
		List<CooperationProdEntity> listCooperationProds=cooperationProdService.getList(CooperationProdEntity.class);
		return listCooperationProds;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		CooperationProdEntity task = cooperationProdService.get(CooperationProdEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody CooperationProdEntity cooperationProd, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CooperationProdEntity>> failures = validator.validate(cooperationProd);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		cooperationProdService.save(cooperationProd);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = cooperationProd.getId();
		URI uri = uriBuilder.path("/rest/cooperationProdController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody CooperationProdEntity cooperationProd) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CooperationProdEntity>> failures = validator.validate(cooperationProd);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		cooperationProdService.saveOrUpdate(cooperationProd);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		cooperationProdService.deleteEntityById(CooperationProdEntity.class, id);
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
		List<CooperationProdEntity> list =  systemService.findHql(" from CooperationProdEntity as a ORDER BY a.orders ASC ",null);

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
					CooperationProdEntity model = list.get((int)i);
					model.setOrders(((int)i+1));
					systemService.updateEntitie(model);
				}
			}


		}
	}
}
