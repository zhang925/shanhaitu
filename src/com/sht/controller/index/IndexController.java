package com.sht.controller.index;


import com.sht.entity.authoritywhite.AuthorityWhiteEntity;
import com.sht.service.authoritywhite.AuthorityWhiteServiceI;
import net.sf.json.JSONObject;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/indexController")
public class IndexController {
   @Autowired
    private AuthorityWhiteServiceI authorityWhiteService;
    @Autowired
    private SystemService systemService;

    @RequestMapping(params = "index")//, method = RequestMethod.GET
    @ResponseBody
    public void index(HttpServletRequest request, HttpServletResponse response) {
        TSUser user = ResourceUtil.getSessionUser();
        List list = new ArrayList();
        list = authorityWhiteService.loadAll(AuthorityWhiteEntity.class);

        JSONObject jobj = new JSONObject();//new一个JSON
        jobj.accumulate("list", list);


        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            System.out.println("获取输出流异常");
            e.printStackTrace();
        }
        out.println("successCallback("+jobj.toString()+")");
        out.flush();
        out.close();
        }

    @RequestMapping(value = "/getUserSIDRest/{username}")
    public void getUserSIDRest(@PathVariable String username, HttpServletRequest request, HttpServletResponse response){
       
    }

    @RequestMapping(params = "indexList")//, method = RequestMethod.GET
    @ResponseBody
    public void indexList( HttpServletRequest request, HttpServletResponse response) {
        TSUser user = ResourceUtil.getSessionUser();

        List list = new ArrayList();
        list =authorityWhiteService.loadAll(AuthorityWhiteEntity.class);
        JSONObject jobj = new JSONObject();//new一个JSON
        jobj.accumulate("list", list);//row是代表显示的页的数据


        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            System.out.println("获取输出流异常");
            e.printStackTrace();
        }
        out.println(jobj.toString());
        out.flush();
        out.close();

    }

    /**
     * 测试
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map test(HttpServletResponse rps){
        Map map = new HashMap();
        map.put("state","当你看到这句话的时候说明自定义服务已经开启！");
        return map;
    }

      /*
       跨域请求调用示例
       $.ajax({
        url:"http://localhost:8080/indexController.do?index",
                type:"get",
                data:{},
        contentType: "application/json;charset=utf-8;",
                dataType:"JSONP",
                jsonp : 'callback', //指定一个查询参数名称来覆盖默认的 jsonp 回调参数名 callback
                jsonpCallback: 'successCallback', //设置回调函数名
                success:function(response, status, xhr){
            console.log("success：");
            console.log(response);
            console.log(status);
            console.log(status);
        },
        error:function(response, status, xhr){
            console.log("error：");
            console.log(response);
            console.log(status);
            console.log(status);
        },
    })*/
}
