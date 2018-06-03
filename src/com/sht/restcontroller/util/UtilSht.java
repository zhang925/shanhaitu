package com.sht.restcontroller.util;

import com.sht.restcontroller.tempentity.UserInfo;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.*;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.*;
import org.jeecgframework.web.system.service.SystemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UtilSht {



    /**
     * 根据 Properties 配置文件的		键	读取	值
     * 项目是启动的
     * @param  Profilename 配置文件的名字
     * @param  proPath 配置文件的地址 	null 和 "" 认为是src 目录下
     * @param  strkey 要获取值的    键
     * @return String
     */
    public static String getPripertyPath(String Profilename,String proPath,String strkey){
        //获取word配置文件
        Properties p=new Properties();
        InputStream is;
        String basePath = "";
        //这样也能取到scr的目录
        //String basePath = request.getSession().getServletContext().getRealPath("/"); +/WEB-INF/classes/
        if(proPath==null || "".equals(proPath)){
            basePath = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
        }else{
            basePath = proPath;
        }
        try {
            //获取陪着文件
            is = new FileInputStream(basePath+"/"+Profilename);
            p.load(is);
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("未找到"+basePath+"目录下的"+Profilename+"配置文件");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常");
            e.printStackTrace();
        }
        String value =  p.getProperty(strkey);
        return  value;
    }


}
