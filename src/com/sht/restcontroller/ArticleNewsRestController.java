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

        String id = articleNewsEntity.getId();
        if(StringUtil.isNotEmpty(id)){//点击详情的时候，需要计算 当前选中的文章新闻的序号。
            //根据ID计算序号
           /* SELECT rownum from

                    ( select (@i:=@i+1) rownum , s.* from test s,(select @i:=0) t  ) tt

            where tt.name='测试'*/
        }


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

