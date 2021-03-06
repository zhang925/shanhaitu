package com.sht.restcontroller;

import com.sht.entity.ask.AskEntity;
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
@RequestMapping("/ask")
/**
 *  提问问题  外部接口
 */
public class AskRestController {

    @Autowired
    private SystemService systemService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(AskEntity askEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<AskEntity> list = new ArrayList<AskEntity>();
        list = systemService.getList(AskEntity.class);
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
        AskEntity askEntity = new AskEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
        }
        askEntity = systemService.getEntity(AskEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(askEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(AskEntity askEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(askEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(askEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(AskEntity askEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(askEntity==null  || askEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        systemService.updateEntitie(askEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(askEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(AskEntity askEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(askEntity==null  || askEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        AskEntity temp = systemService.getEntity(AskEntity.class,askEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(AskEntity.class,askEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

