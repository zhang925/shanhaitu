package com.sht.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.sht.entity.articlenews.ArticleNewsEntity;
import com.sht.entity.selectedarticles.SelectedArticlesEntity;
import com.sht.restcontroller.tempentity.AjaxMsg;
import com.sht.restcontroller.util.UtilSht;
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
@RequestMapping("/selected/article")
/**
 *  精选文章 外部接口
 */
public class SelectedArticleRestController {

    @Autowired
    private SystemService systemService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(SelectedArticlesEntity selectedArticlesEntity, HttpServletResponse response, HttpServletRequest request){
    /*  AjaxMsg ajaxMsg = new AjaxMsg();
        List<SelectedArticlesEntity> list = new ArrayList<SelectedArticlesEntity>();
        list = systemService.getList(SelectedArticlesEntity.class);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(list);
        return ajaxMsg;*/

        //热门文章关系表和热门文章是一一 对应的 临时实体 还需要转化，这里 采用sql

        AjaxMsg ajaxMsg = new AjaxMsg();

        String sql = "SELECT ss.id as id ,ss.publish_time as publish_time , ss.closing_time  as closing_time,\n" +
                "ss.orders as orders, ss.article_id as article_id,sa.title as  title , sa.summary as summary,\n" +
                "sa.content as content, sa.author as author,sa.creator_id as creator_id,sa.editor_id as editor_id,\n" +
                "sa.creator as creator, sa.editor as editor,sa.created_time as created_time,sa.`status` as `status`,\n" +
                "sa.image_url as image_url, sa.like_count as like_count, sa.visit_count as visit_count\n" +
                " FROM sht_selected_articles as ss, sht_article_news as sa WHERE ss.article_id = sa.id  ";
        String countSql = "select count(0) from sht_selected_articles as ss, sht_article_news as sa WHERE ss.article_id = sa.id   ";

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
        AjaxMsg ajaxMsg = new AjaxMsg();
        SelectedArticlesEntity selectedArticlesEntity = new SelectedArticlesEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
        }
        selectedArticlesEntity = systemService.getEntity(SelectedArticlesEntity.class,id);
        ArticleNewsEntity articleNewsEntity = new ArticleNewsEntity();
        if(selectedArticlesEntity!=null && selectedArticlesEntity.getArticleId()!=null){
            articleNewsEntity = systemService.getEntity(ArticleNewsEntity.class,selectedArticlesEntity.getArticleId());
            selectedArticlesEntity.setArticleNewsEntity(articleNewsEntity);
        }
        //获取文章信息详情
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(selectedArticlesEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(SelectedArticlesEntity selectedArticlesEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(selectedArticlesEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(selectedArticlesEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(SelectedArticlesEntity selectedArticlesEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(selectedArticlesEntity==null  || selectedArticlesEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        systemService.updateEntitie(selectedArticlesEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(selectedArticlesEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(SelectedArticlesEntity selectedArticlesEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(selectedArticlesEntity==null  || selectedArticlesEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        SelectedArticlesEntity temp = systemService.getEntity(SelectedArticlesEntity.class,selectedArticlesEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(SelectedArticlesEntity.class,selectedArticlesEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

