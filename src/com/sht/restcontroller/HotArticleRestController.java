package com.sht.restcontroller;



import com.alibaba.fastjson.JSONObject;
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
import java.util.Map;

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


    //计算上一篇下一篇
    @RequestMapping(value = "/next",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg pageNext( HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        String id = request.getParameter("id");
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("未获取到ID信息");
            return ajaxMsg;
        }

        //以后每次重写这个tableSql 就行了
        //获取 所有 热门文章 的 sql
        String tableSql = " ( SELECT " +
                "        ha.id ,sa.title,sa.summary,sa.content,sa.author, " +
                "                sa.creator,sa.editor,sa.created_time,sa.cate_id, " +
                "                sa.image_url,sa.like_count,sa.visit_count, " +
                "                ha.publish_time,ha.closing_time,ha.orders,ha.`status` " +
                "        FROM sht_hot_article AS ha , sht_article_news AS sa  WHERE sa.id = ha.article_id " +
                "        ORDER BY ha.orders ASC )   ";


        //计算本篇的位置
        int num = 0;
        if(StringUtil.isNotEmpty(id)){//点击详情的时候，需要计算 当前选中的文章新闻的序号。
            //根据ID计算序号
            String numSql = " SELECT rownum from ( select (@i:=@i+1) rownum , s.* from "+ tableSql +" as  s ,(select @i:=0) t ) tt  where tt.id='"+id+"' ";
            Map map = systemService.findOneForJdbc(numSql);
            if(map!=null){
                Object rownumObj = map.get("rownum");//获取该条数据在数据库中的位置
                if(rownumObj!=null){
                    String rownum = rownumObj.toString();//此刻 获取的  是1.0  2.0 3.0 之类的浮点数
                    rownum = rownum.substring(0,rownum.indexOf("."));//获取到位置
                    num = Integer.valueOf(rownum);
                }
            }
        }
        //总条数
        String countSql = "select count(0) from  "+ tableSql +" as s  where 1=1  ";
        long total  = systemService.getCountForJdbcParam(countSql,new Object[]{});//总条数，只要能进这个方法说明至少有哦一条数据
        int totalNum = (int)total;
        int preNum=1;//前一条数据
        int nextNum=1;//后一条数据
        boolean first = false;//是否是第一条，
        boolean last = false;//是否是最后一条
        if(num ==1 ){//第一条
            first = true;
        }
        if(num>1 && num <totalNum ){//从第二条开始
            preNum = num -1;
            nextNum = num +1;
        }
        if(num == totalNum){//当前条是最后一条
            last = true;
        }
        Map preMap = null;//上一篇
        Map mapNow = null; //本篇
        Map nextMap = null;//下一篇


        /*
        SELECT ha.id ,sa.title,sa.summary,sa.content,sa.author,  sa.creator,sa.editor,sa.created_time,sa.cate_id, sa.image_url,sa.like_count,sa.visit_count,
        ha.publish_time,ha.closing_time,ha.orders,ha.`status`
        FROM sht_hot_article AS ha , sht_article_news AS sa  WHERE sa.id = ha.article_id  ORDER BY ha.orders ASC
        */


        if(!first){//不是第一篇计算 上一篇
            //上一篇
            String preSql = " SELECT * from ( select (@i:=@i+1) rownum , s.* from "+ tableSql +" s,(select @i:=0) t ) tt  where rownum ="+ preNum;
            preMap = systemService.findOneForJdbc(preSql);
        }
        //本篇
        String sql = " SELECT * from ( select (@i:=@i+1) rownum , s.* from "+ tableSql +" s,(select @i:=0) t ) tt  where rownum ="+ num;
        mapNow = systemService.findOneForJdbc(sql);

        if(!last){//不是最后一篇，计算下一篇
            //下一篇
            String nextSql = " SELECT * from ( select (@i:=@i+1) rownum , s.* from "+ tableSql +" s,(select @i:=0) t ) tt  where rownum ="+ nextNum;
            nextMap = systemService.findOneForJdbc(nextSql);
        }

        JSONObject obj = new JSONObject();
        obj.put("preActicle", preMap);//上一篇
        obj.put("nowActicle", mapNow);//本篇
        obj.put("nextActicle", nextMap);//下一篇
        obj.put("first",first);//是否是第一条
        obj.put("last",last);//是否是最后一条
        ajaxMsg.setModel(obj);
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

