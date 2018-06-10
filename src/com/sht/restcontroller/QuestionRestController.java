package com.sht.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.sht.entity.question.QuestionEntity;
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
@RequestMapping("/question")
/**
 * 问题的外部接口
 */
public class QuestionRestController {

    @Autowired
    private SystemService systemService;


    /***分页获取list*/
    @RequestMapping(value = "/list")
    @ResponseBody
    public AjaxMsg list(QuestionEntity questionEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();

        String sql = "select * from sht_question where 1=1 ";//这里不采用jeecg的方法了，方便以后其他人维护。
        String countSql = "select count(0) from sht_question  where 1=1  ";
        String where = "";
        //拼接条件
        //要根据ID查询
        String tagid = request.getParameter("tagid");//分类tagid
        if(!StringUtil.isEmpty(tagid)){//非空
           //说明 要根据 标签ID 查询
            List list01 = systemService.findListbySql(" SELECT question_id as questionId FROM sht_question_relation_tag WHERE  1=1 and tag_id = '"+tagid+"' ");
            String id = "";
            if(list01!=null && list01.size()>0){
               for(Object obj : list01){
                   id = id + "," + "'"+obj+"'";
               }
            }
            id = "('0'" + id + ") ";
            where = where + " and id in " + id ;
        }

        String title = questionEntity.getTitle();//分类ID
        if(!StringUtil.isEmpty(title)){//非空
            where = where + " and title like '%"+title+"%' ";
        }
        sql = sql + where;
        countSql = countSql + where;
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
        QuestionEntity questionEntity = new QuestionEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
        }
        questionEntity = systemService.getEntity(QuestionEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(questionEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(QuestionEntity questionEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(questionEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(questionEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(QuestionEntity questionEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(questionEntity==null  || questionEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        systemService.updateEntitie(questionEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(questionEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(QuestionEntity questionEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(questionEntity==null  || questionEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        QuestionEntity temp = systemService.getEntity(QuestionEntity.class,questionEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(QuestionEntity.class,questionEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

