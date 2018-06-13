package com.sht.restcontroller;

import com.sht.entity.reportrelatedimages.ReportRelatedImagesEntity;
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
@RequestMapping("/report/images")
/**
 *  调研报告相关图集  外部接口
 */
public class ReportRelatedImagesRestController {

    @Autowired
    private SystemService systemService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(ReportRelatedImagesEntity reportRelatedImagesEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<ReportRelatedImagesEntity> list = new ArrayList<ReportRelatedImagesEntity>();
        list = systemService.getList(ReportRelatedImagesEntity.class);
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
        ReportRelatedImagesEntity reportRelatedImagesEntity = new ReportRelatedImagesEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
            return ajaxMsg;
        }
        reportRelatedImagesEntity = systemService.getEntity(ReportRelatedImagesEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(reportRelatedImagesEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(ReportRelatedImagesEntity reportRelatedImagesEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(reportRelatedImagesEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(reportRelatedImagesEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(ReportRelatedImagesEntity reportRelatedImagesEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(reportRelatedImagesEntity==null  || reportRelatedImagesEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.updateEntitie(reportRelatedImagesEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(reportRelatedImagesEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(ReportRelatedImagesEntity reportRelatedImagesEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(reportRelatedImagesEntity==null  || reportRelatedImagesEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        ReportRelatedImagesEntity temp = systemService.getEntity(ReportRelatedImagesEntity.class,reportRelatedImagesEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(ReportRelatedImagesEntity.class,reportRelatedImagesEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

