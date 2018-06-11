package com.sht.restcontroller;



import com.sht.entity.articlenews.ArticleNewsEntity;
import com.sht.entity.hotarticle.HotArticleEntity;
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
@RequestMapping("/article/hot")
/**
 * 热门文章
 *
 */
public class HotArticleRestController {

    @Autowired
    private SystemService systemService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(HotArticleEntity hotArticleEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<HotArticleEntity> list = new ArrayList<HotArticleEntity>();
        list = systemService.getList(HotArticleEntity.class);
        //热门文章不做分页，只显示全部
        List<HotArticleEntity> listRes = new ArrayList<HotArticleEntity>();
        if(list!=null && list.size()>0){
            //获取文章的具体信息
            for(HotArticleEntity h : list ){
                if(h.getArticleId()!=null){
                    ArticleNewsEntity articleNewsEntity = systemService.getEntity(ArticleNewsEntity.class,h.getArticleId());
                    h.setArticleNewsEntity(articleNewsEntity);
                    listRes.add(h);
                }
            }
        }
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(listRes);
        return ajaxMsg;
    }

    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg info(@PathVariable String id, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        HotArticleEntity hotArticleEntity = new HotArticleEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
        }
        hotArticleEntity = systemService.getEntity(HotArticleEntity.class,id);
        //获取详情
        if(hotArticleEntity!=null && hotArticleEntity.getArticleId()!=null){
            ArticleNewsEntity articleNewsEntity = systemService.getEntity(ArticleNewsEntity.class,hotArticleEntity.getArticleId());
            hotArticleEntity.setArticleNewsEntity(articleNewsEntity);
        }
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(hotArticleEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(HotArticleEntity hotArticleEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(hotArticleEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(hotArticleEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(HotArticleEntity hotArticleEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(hotArticleEntity==null  || hotArticleEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        systemService.updateEntitie(hotArticleEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(hotArticleEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(HotArticleEntity hotArticleEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(hotArticleEntity==null  || hotArticleEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        HotArticleEntity temp = systemService.getEntity(HotArticleEntity.class,hotArticleEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(HotArticleEntity.class,hotArticleEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

