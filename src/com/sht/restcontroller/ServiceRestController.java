package com.sht.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.sht.entity.service.ServiceEntity;
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
@RequestMapping("/service")
/**
 * 出海服务  外部接口
 */
public class ServiceRestController {

    @Autowired
    private SystemService systemService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(ServiceEntity serviceEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<ServiceEntity> list = new ArrayList<ServiceEntity>();
        list = systemService.getList(ServiceEntity.class);
        //

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(list);
        return ajaxMsg;
    }

    /**
     * 根据业务类型分页获取出海服务的信息
     * @param serviceEntity
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/list/info",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg listInfo(ServiceEntity serviceEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();

        // 说是 查询 用户信息
        String sql2 = "";


        /*SELECT * FROM t_s_user as tsu
        LEFT JOIN
        t_s_base_user tsbu
        ON
        tsbu.ID = tsu.id
        LEFT JOIN
        sht_comment as sc
        ON tsu.id = sc.use_id
        LEFT JOIN
        sht_service as ss
        ON sc.service_id = ss.id
        LEFT JOIN
        sht_bus_type sbt
        ON  sbt.id = ss.bus_type_id;*/




        String sql = "select * from sht_article_news where 1=1 ";//这里不采用jeecg的方法了，方便以后其他人维护。
        String countSql = "select count(0) from sht_article_news  where 1=1  ";
        String where = "";
        //拼接条件
        //要根据ID查询
        String fenleiid = "";//分类ID
        if(!StringUtil.isEmpty(fenleiid)){//非空
            where = " and cate_id ='"+fenleiid+"' ";
        }
        String title = "";//标题模糊查询
        if(!StringUtil.isEmpty(title)){//非空
            where = where + " and title like '%"+title+"%' ";
        }
        countSql = countSql + where;
        where = where + " order by created_time DESC ";
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
        ServiceEntity serviceEntity = new ServiceEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
        }
        serviceEntity = systemService.getEntity(ServiceEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(serviceEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(ServiceEntity serviceEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();



        systemService.save(serviceEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(serviceEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(ServiceEntity serviceEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(serviceEntity==null  || serviceEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        systemService.updateEntitie(serviceEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(serviceEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(ServiceEntity serviceEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(serviceEntity==null  || serviceEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        ServiceEntity temp = systemService.getEntity(ServiceEntity.class,serviceEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(ServiceEntity.class,serviceEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

