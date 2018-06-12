package com.sht.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.sht.entity.articlenews.ArticleNewsEntity;
import com.sht.restcontroller.tempentity.AjaxMsg;
import com.sht.restcontroller.tempentity.UserInfo;
import com.sht.restcontroller.util.MySessionContext;
import com.sht.restcontroller.util.UtilEmail;
import com.sht.restcontroller.util.UtilSht;
import com.sht.restcontroller.util.UtilShtRest;
import com.sht.service.articlenews.ArticleNewsServiceI;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.system.controller.core.LoginController;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.MutiLangServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**文章新闻列表*/
@RestController
@RequestMapping("/article")
public class ArticleNewsRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private MutiLangServiceI mutiLangService;
    @Autowired
    private ArticleNewsServiceI articleNewsService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public AjaxMsg list(ArticleNewsEntity articleNewsEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        String sql = "select * from sht_article_news where 1=1 ";//这里不采用jeecg的方法了，方便以后其他人维护。
        String countSql = "select count(0) from sht_article_news  where 1=1  ";
        String where = "";
        //拼接条件
        //要根据ID查询
        String fenleiid = articleNewsEntity.getCateId();//分类ID
        if(!StringUtil.isEmpty(fenleiid)){//非空
            where = " and cate_id ='"+fenleiid+"' ";
        }
        String title = articleNewsEntity.getTitle();//标题模糊查询
        if(!StringUtil.isEmpty(title)){//非空
            where = where + " and title like '%"+title+"%' ";
        }
        countSql = countSql + where;
        where = where + " order by created_time DESC ";
        sql = sql + where;
        long num  = systemService.getCountForJdbcParam(countSql,new Object[]{});//总条数
        Integer page = UtilSht.getPage(request);
        Integer row = UtilSht.getRow(request);

      /*  //处理上一篇文章，下一篇文章的 方法
        String id = articleNewsEntity.getId();
        if(StringUtil.isNotEmpty(id)){//点击详情的时候，需要计算 当前选中的文章新闻的序号。
            //根据ID计算序号
            String numSql = " SELECT rownum from ( select (@i:=@i+1) rownum , s.* from sht_article_news s,(select @i:=0) t ) tt  where tt.id='"+id+"' ";
            Map map = systemService.findOneForJdbc(numSql);
            if(map!=null){
                Object rownumObj = map.get("rownum");//获取该条数据在数据库中的位置
                if(rownumObj!=null){
                    String rownum = rownumObj.toString();//此刻 获取的  是1.0  2.0 3.0 之类的浮点数
                    rownum = rownum.substring(0,rownum.indexOf("."));
                    page = Integer.valueOf(rownum);//当前也为 该字段在数据库的 排列号。
                    row =1;//每一页智能显示一条数据 这样才能 达到 上一篇文章的效果、下一篇文章的效果
                }
            }
        }
*/
        int total = (int)num;//总条数
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
        //计算本篇的位置
        int num = 0;
        if(StringUtil.isNotEmpty(id)){//点击详情的时候，需要计算 当前选中的文章新闻的序号。
            //根据ID计算序号
            String numSql = " SELECT rownum from ( select (@i:=@i+1) rownum , s.* from sht_article_news s,(select @i:=0) t ) tt  where tt.id='"+id+"' ";
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
        String countSql = "select count(0) from sht_article_news  where 1=1  ";
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
        Map nowMap = null; //本篇
        Map nextMap = null;//下一篇
        if(!first){//不是第一篇计算 上一篇
            //上一篇
            String preSql = " SELECT * from ( select (@i:=@i+1) rownum , s.* from sht_article_news s,(select @i:=0) t ) tt  where rownum ="+ preNum;
             preMap = systemService.findOneForJdbc(preSql);
        }
        //本篇
        String sql = " SELECT * from ( select (@i:=@i+1) rownum , s.* from sht_article_news s,(select @i:=0) t ) tt  where rownum ="+ num;
        nowMap = systemService.findOneForJdbc(sql);

        if(!last){//不是最后一篇，计算下一篇
            //下一篇
            String nextSql = " SELECT * from ( select (@i:=@i+1) rownum , s.* from sht_article_news s,(select @i:=0) t ) tt  where rownum ="+ nextNum;
            nextMap = systemService.findOneForJdbc(nextSql);
        }

        JSONObject obj = new JSONObject();
        obj.put("preActicle", preMap);//上一篇
        obj.put("nowActicle", nowMap);//本篇
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
        ArticleNewsEntity articleNewsEntity = new ArticleNewsEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
        }
        articleNewsEntity = articleNewsService.getEntity(ArticleNewsEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(articleNewsEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(ArticleNewsEntity articleNewsEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();

        //根据前端传来的cookiename获取 新建人信息
        String userName = request.getParameter("userName");
        TSUser tsUser =  UtilShtRest.getTSUserByUserName(systemService,userName);
        if(tsUser!=null && tsUser.getId()!=null){
            articleNewsEntity.setCreator(tsUser.getRealName());
            articleNewsEntity.setCreatorId(tsUser.getId());
        }
        articleNewsEntity.setCreatedTime(new Date());

        articleNewsService.save(articleNewsEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(articleNewsEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(ArticleNewsEntity articleNewsEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(articleNewsEntity==null  || articleNewsEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        articleNewsService.updateEntitie(articleNewsEntity);

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(articleNewsEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(ArticleNewsEntity articleNewsEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(articleNewsEntity==null  || articleNewsEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        //判断该实体是否存在
        ArticleNewsEntity temp = systemService.getEntity(ArticleNewsEntity.class,articleNewsEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }

        articleNewsService.deleteEntityById(ArticleNewsEntity.class,articleNewsEntity.getId());
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(articleNewsEntity);
        return ajaxMsg;
    }

}

