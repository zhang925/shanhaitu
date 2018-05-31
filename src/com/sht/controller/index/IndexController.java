package com.sht.controller.index;


import com.sht.entity.authoritywhite.AuthorityWhiteEntity;
import com.sht.service.authoritywhite.AuthorityWhiteServiceI;
import net.sf.json.JSONObject;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/index")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class IndexController {

   @Autowired
    private AuthorityWhiteServiceI authorityWhiteService;
    @Autowired
    private SystemService systemService;
    //注意，当是 value 的时候 调用 api/index/val值
    //是param的时候，就是 index.do?param 了


    /**
     * 测试
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public Map test(HttpServletResponse rps,HttpServletResponse response,HttpServletRequest request){
        Map map = new HashMap();
        map.put("state","当你看到这句话的时候说明自定义服务已经开启！");
        return map;
    }


    @RequestMapping(value = "authorityList")//, method = RequestMethod.GET
    @ResponseBody
    public List authorityList( HttpServletRequest request, HttpServletResponse response) {
        TSUser user = ResourceUtil.getSessionUser();
        List list = new ArrayList();
        list =authorityWhiteService.loadAll(AuthorityWhiteEntity.class);
        return list;

    }


    @RequestMapping(value = "/getUserSIDRest/{username}")
    public void getUserSIDRest(@PathVariable String username, HttpServletRequest request, HttpServletResponse response){

    }









    //这里不在使用jsonp 了 找到了 解决方法 CORSFilter 类
    @RequestMapping(value = "testjsonp")//, method = RequestMethod.GET
    @ResponseBody
    public void testjsonp( HttpServletResponse response,HttpServletRequest request) {
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


      /*$.ajax({
        url: 'http://192.168.158.57:8080/api/index/test',
                type: 'get',
                dataType: 'json',
                contentType:'application/json',
                // data: JSON.stringify(postJson1),
				*//*beforeSend : function(request) {
					request.setRequestHeader("Authorization", "Bearer QBfEmk3a6LM6RAVfmiyOI0w5vKi8ek");
				},*//*
                success: function (json) {
            console.log("调用成功");
            console.log(json)
					*//*var data = eval(json);
					var result = data.result;*//*

        },
        error: function (json){
            console.log("Error");
            console.log(json);
        }
    });*/

}
