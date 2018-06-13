package com.sht.restcontroller;

import com.sht.entity.reportrelateddocs.ReportRelatedDocsEntity;
import com.sht.restcontroller.tempentity.AjaxMsg;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report/doc")
/**
 *  调研报告相关资料  外部接口
 */
public class ReportRelatedDocRestController {

    @Autowired
    private SystemService systemService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(ReportRelatedDocsEntity reportRelatedDocsEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<ReportRelatedDocsEntity> list = new ArrayList<ReportRelatedDocsEntity>();
        list = systemService.getList(ReportRelatedDocsEntity.class);
        //

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(list);
        return ajaxMsg;
    }

    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg info(@PathVariable String id, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        ReportRelatedDocsEntity reportRelatedDocsEntity = new ReportRelatedDocsEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
            return ajaxMsg;
        }
        reportRelatedDocsEntity = systemService.getEntity(ReportRelatedDocsEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(reportRelatedDocsEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(ReportRelatedDocsEntity reportRelatedDocsEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(reportRelatedDocsEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(reportRelatedDocsEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(ReportRelatedDocsEntity reportRelatedDocsEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(reportRelatedDocsEntity==null  || reportRelatedDocsEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.updateEntitie(reportRelatedDocsEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(reportRelatedDocsEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(ReportRelatedDocsEntity reportRelatedDocsEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(reportRelatedDocsEntity==null  || reportRelatedDocsEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        ReportRelatedDocsEntity temp = systemService.getEntity(ReportRelatedDocsEntity.class,reportRelatedDocsEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(ReportRelatedDocsEntity.class,reportRelatedDocsEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

