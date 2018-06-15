package com.sht.restcontroller;

import com.sht.entity.lawdoccatalog.LawdocCatalogEntity;
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
import java.util.Map;

@RestController
@RequestMapping("/lawdoccatalog")
/**
 *  政策法规分类 外部接口
 */
public class LawdocCatalogRestController {

    @Autowired
    private SystemService systemService;


    /**获取所有分类*/
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(LawdocCatalogEntity lawdocCatalogEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<LawdocCatalogEntity> list = new ArrayList<LawdocCatalogEntity>();
        list = systemService.getList(LawdocCatalogEntity.class);
        //

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(list);
        return ajaxMsg;
    }


    @RequestMapping(value = "/list/level",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg level(HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        String id = request.getParameter("id");
        String sql  = "";
        if(StringUtil.isNotEmpty(id)){// 传来了ID 此id作为 pid 查询 数据
            sql = " select * from sht_law_doc_catalog where parent_id='"+id+"'";
        }else{//第一次进入没有点击
            sql = " select * from sht_law_doc_catalog where level=1 ";
        }
        sql = sql + " order by orders asc ";
        List<LawdocCatalogEntity> list = systemService.findListbySql(sql);
        //判断是否有下一级
        //这里在数据库中录入了，不 判断了
       /* if(list!=null){
            for(LawdocCatalogEntity obj : list){

            }
        }*/

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(list);
        return ajaxMsg;
    }




    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg info(@PathVariable String id, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        LawdocCatalogEntity lawdocCatalogEntity = new LawdocCatalogEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
        }
        lawdocCatalogEntity = systemService.getEntity(LawdocCatalogEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(lawdocCatalogEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(LawdocCatalogEntity lawdocCatalogEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(lawdocCatalogEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(lawdocCatalogEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(LawdocCatalogEntity lawdocCatalogEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(lawdocCatalogEntity==null  || lawdocCatalogEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        systemService.updateEntitie(lawdocCatalogEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(lawdocCatalogEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(LawdocCatalogEntity lawdocCatalogEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(lawdocCatalogEntity==null  || lawdocCatalogEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        LawdocCatalogEntity temp = systemService.getEntity(LawdocCatalogEntity.class,lawdocCatalogEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(LawdocCatalogEntity.class,lawdocCatalogEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

