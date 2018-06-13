package com.sht.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.sht.entity.articlenews.ArticleNewsEntity;
import com.sht.entity.investigatereport.InvestigateReportEntity;
import com.sht.restcontroller.tempentity.AjaxMsg;
import com.sht.restcontroller.tempentity.AjaxMsgFactory;
import com.sht.restcontroller.util.UtilSht;
import com.sht.service.investigatereport.InvestigateReportServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller
 * @Description: 调研报告
 * @author
 * @date 2018-05-29 21:50:25
 * @version V1.0   
 *
 */
@RestController
@RequestMapping("/investreport")
public class InvestReportRestController {
	@Autowired
	private SystemService systemService;


	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public AjaxMsg list(InvestigateReportEntity investigateReportEntity, HttpServletResponse response, HttpServletRequest request){
		AjaxMsg ajaxMsg = new AjaxMsg();
		///List<InvestigateReportEntity> list = new ArrayList<InvestigateReportEntity>();
		//list = systemService.getList(InvestigateReportEntity.class);
		//需要分页

		String sql = " SELECT * from sht_investigate_report where 1=1 ";
		String countSql = "select count(0) from sht_investigate_report where 1=1  ";

		/* String where = "";
        //拼接条件
        sql = sql + where;
        countSql = countSql + where;*/

		long num  = systemService.getCountForJdbcParam(countSql,new Object[]{});//总条数
		Integer page = UtilSht.getPage(request);
		Integer row = UtilSht.getRow(request);
		int total = (int)num;
		Integer totalPage = (total%row==0) ? (total/row) : ((total/row)+1);
		if(page >= totalPage){
			page = totalPage;
		}
		if(page==0){
			page =1;
		}
		if(totalPage == 0){
			totalPage =1;
		}
		List<Map<String, Object>> list2 = systemService.findForJdbc(sql,page,row);
		JSONObject obj = new JSONObject();
		obj.put("result", list2);
		obj.put("total",total);
		obj.put("totalPage",totalPage);
		obj.put("page",page);
		obj.put("row",row);


		ajaxMsg.setMsg("success");
		ajaxMsg.setResponsecode(HttpStatus.OK.value());
		ajaxMsg.setModel(obj);
		return ajaxMsg;
	}

	@RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
	@ResponseBody
	public AjaxMsg info(@PathVariable String id, HttpServletResponse response, HttpServletRequest request){
		InvestigateReportEntity investigateReportEntity;
		if(StringUtil.isEmpty(id)){
			return AjaxMsgFactory.createErrorMsg(null, HttpStatus.NOT_FOUND, "id不能为空");
		}
		investigateReportEntity = systemService.getEntity(InvestigateReportEntity.class,id);

		return AjaxMsgFactory.createSuccessMsg(investigateReportEntity);
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsg save(InvestigateReportEntity investigateReportEntity,HttpServletResponse response,HttpServletRequest request){
		systemService.save(investigateReportEntity);
		return AjaxMsgFactory.createSuccessMsg(investigateReportEntity);
	}

	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsg update(InvestigateReportEntity investigateReportEntity,HttpServletResponse response,HttpServletRequest request){
		AjaxMsg ajaxMsg = new AjaxMsg();
		if(investigateReportEntity==null  || investigateReportEntity.getId()==null){
			ajaxMsg.setMsg("id不能为空");
			ajaxMsg.setResponsecode(HttpStatus.OK.value());
		}
		systemService.updateEntitie(investigateReportEntity);
		//
		ajaxMsg.setMsg("success");
		ajaxMsg.setResponsecode(HttpStatus.OK.value());
		ajaxMsg.setModel(investigateReportEntity);
		return ajaxMsg;
	}

	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxMsg delete(InvestigateReportEntity investigateReportEntity,HttpServletResponse response,HttpServletRequest request){
		AjaxMsg ajaxMsg = new AjaxMsg();
		if(investigateReportEntity==null  || investigateReportEntity.getId()==null){
			ajaxMsg.setMsg("id不能为空");
			ajaxMsg.setResponsecode(HttpStatus.OK.value());
			return ajaxMsg;
		}
		//判断该实体是否存在
		InvestigateReportEntity temp = systemService.getEntity(InvestigateReportEntity.class,investigateReportEntity.getId());
		if(temp==null || temp.getId()==null){
			ajaxMsg.setMsg("该实体不存在！");
			ajaxMsg.setResponsecode(HttpStatus.OK.value());
			return ajaxMsg;
		}
		systemService.deleteEntityById(InvestigateReportEntity.class,investigateReportEntity.getId());

		ajaxMsg.setMsg("success");
		ajaxMsg.setResponsecode(HttpStatus.OK.value());
		return ajaxMsg;
	}


}
