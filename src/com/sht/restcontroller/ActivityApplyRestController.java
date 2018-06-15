package com.sht.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.sht.entity.activityapply.ActivityApplyEntity;
import com.sht.entity.comment.CommentEntity;
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
@RequestMapping("/activity/apply")
/**
 *  活动报名 外部接口
 */
public class ActivityApplyRestController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(ActivityApplyEntity activityApplyEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        String sql = "select * from sht_activity_apply where 1=1 ";//这里不采用jeecg的方法了，方便以后其他人维护。
        String countSql = "select count(0) from sht_activity_apply  where 1=1  ";
        String where = "";


        //拼接条件
        //要根据ID查询
       /* int fenleiid = activityApplyEntity.getStatus();//分类ID
        if(){//非空
            where = " and cate_id ='"+fenleiid+"' ";
        }*/

        countSql = countSql + where;
        //where = where + " order by created_time DESC ";
        sql = sql + where;
        long num  = systemService.getCountForJdbcParam(countSql,new Object[]{});//总条数
        Integer page = UtilSht.getPage(request);
        Integer row = UtilSht.getRow(request);

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
        ActivityApplyEntity activityApplyEntity = new ActivityApplyEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
            return ajaxMsg;
        }
        activityApplyEntity = systemService.getEntity(ActivityApplyEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(activityApplyEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(ActivityApplyEntity activityApplyEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(activityApplyEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(activityApplyEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(ActivityApplyEntity activityApplyEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(activityApplyEntity==null  || activityApplyEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.updateEntitie(activityApplyEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(activityApplyEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(ActivityApplyEntity activityApplyEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(activityApplyEntity==null  || activityApplyEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        ActivityApplyEntity temp = systemService.getEntity(ActivityApplyEntity.class,activityApplyEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(ActivityApplyEntity.class,activityApplyEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

