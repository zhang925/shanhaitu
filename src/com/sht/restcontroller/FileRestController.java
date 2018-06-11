package com.sht.restcontroller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件上传下载的 公用类
 */
@RestController
@RequestMapping("file")
public class FileRestController {




    @RequestMapping("index")
    @ResponseBody
    public void index(HttpServletRequest request, HttpServletResponse response){
        String path = request.getSession().getServletContext().getRealPath("/");

        System.out.println(path);
    }

    @RequestMapping("test")
    public String lxPage(HttpServletRequest request, HttpServletResponse response){



        return "file/fileUpload";
    }

    /**
     * 头像图片上传
     */
    @RequestMapping(value = "/save/pic", method = RequestMethod.POST)
    public void saveHeaderPic(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response){

        String resMsg = "";
        try {
            long  startTime= System.currentTimeMillis();
            System.out.println("fileName："+file.getOriginalFilename());
            //String path="/Users/loukai/easylife/files/"+new Date().getTime()+file.getOriginalFilename();
            //存储到 项目的发布目录
            String basePath = request.getSession().getServletContext().getRealPath("/");
            String path= basePath +"uploadfile/HeaderPic/"+new Date().getTime()+file.getOriginalFilename();
            File newFile=new File(path);
            if(!newFile.exists()){//文件夹不存在，创建文件夹
                newFile.mkdirs();
            }
            //通过CommonsMultipartFile的方法直接写文件
            file.transferTo(newFile);
            long  endTime= System.currentTimeMillis();
            System.out.println("运行时间："+ String.valueOf(endTime-startTime)+"ms");
            resMsg = "1";
            response.getWriter().write(resMsg);
        } catch (Exception e) {
            e.printStackTrace();
            resMsg = "0";
        }


    }

    /**
     * 通知公告的信息 上传
     */
    @RequestMapping(value = "/save/notice", method = RequestMethod.POST)
    public void saveNoticeFile(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String resMsg = "";
        try {
             String fileName = file.getOriginalFilename();
            //String path="/Users/loukai/easylife/files/"+new Date().getTime()+file.getOriginalFilename();
            //服务器的真是路径，发布项目的 根路径 F：aa/bb
            String basePath = request.getSession().getServletContext().getRealPath("/");
            //按照时间 建立一个文件 每天一个文件夹
            SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");//格式化 文件夹 名字
            String timestr =  sd.format(new Date());
            SimpleDateFormat sd2 = new SimpleDateFormat("yyyyMMddHHmmss");//格式化 文件 名字的前缀
            //因为 Spring MVC 对静态 资源的控制原因，这里的file 上传到，"WEB-INF/skin/"下面
            String originname = file.getOriginalFilename();//文件的原名字
            String addPath= "userfiles/rest/noticefile/userid/"+timestr+"/"+sd2.format(new Date())+originname;
            String path = basePath + addPath;
            File newFile=new File(path);
            if(!newFile.exists()){
                newFile.mkdirs();
            }
            file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
            response.setCharacterEncoding("UTF8");
            response.getWriter().write(addPath);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     *  文件下载 根据文件地址 下载
     * @param request
     * @param response
     * @param src //文件路径
     */
    @RequestMapping(value = "down/src")
    @ResponseBody
    public void  downFileBySrc(HttpServletRequest request, HttpServletResponse response, String src){
        String downLoadPath = "";// 下载地址，是真实的 盘符 HttpServletResponse
        // storeName 类似  skin/uploadfile/noticefile/20180604/20180604114710QQ截图.png
        String basePath = request.getSession().getServletContext().getRealPath("/");// F:/platform/
        downLoadPath =  basePath +"WEB-INF/" +src ;
        String fileName = src.substring((src.lastIndexOf("/")+1),src.length());//获得 20180604114710QQ截图.png
        String storeName =  fileName.substring(14,fileName.length());//下载后要显示的文件名字 QQ截图.png
        try{
            request.setCharacterEncoding("UTF-8");
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;

            //获取项目根目录
            //String ctxPath = request.getSession().getServletContext().getRealPath("");
            //获取下载文件
            //String downLoadPath = ctxPath+"/uploadFile/"+ storeName;
            //这里暂时认为文件已经确定
            //获取文件的长度

            File file = new File(downLoadPath);
            if (!file.exists()) {//文件不存在
                try {
                    response.sendError(404, "服务器文件已经丢失，下载失败!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //return response;

            }
            long fileLength = file.length();
            //设置文件输出类型
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(storeName.getBytes("utf-8"), "ISO8859-1"));
            //设置输出长度
            response.setHeader("Content-Length", String.valueOf(fileLength));
            //获取输入流
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            //输出流
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            //关闭流
            bis.close();
            bos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        //return  response;
    }


    /**
     *  文件下载，根据文件表的ID 关联下载 预留功能，暂时不做处理
     * @param request
     * @param response
     * @param storeName
     * @param contentType
     */
    @RequestMapping(value = "down/id")
    public HttpServletResponse downFileById(HttpServletRequest request, HttpServletResponse response, String storeName, String contentType){
        String downLoadPath = "F:/skin/uploadfile/noticefile/20180604/20180604114710QQ截图.png";//测试暂时定死
        storeName = "下载后要保存的名字.png";
        try{
            request.setCharacterEncoding("UTF-8");
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;

            //获取项目根目录
            //String ctxPath = request.getSession().getServletContext().getRealPath("");
            //获取下载文件
            //String downLoadPath = ctxPath+"/uploadFile/"+ storeName;
            //这里暂时认为文件已经确定
            //获取文件的长度

            File file = new File(downLoadPath);
            if (!file.exists()) {//文件不存在
                try {
                    response.sendError(404, "服务器文件已经丢失，下载失败!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }
            long fileLength = file.length();
            //设置文件输出类型
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(storeName.getBytes("utf-8"), "ISO8859-1"));
            //设置输出长度
            response.setHeader("Content-Length", String.valueOf(fileLength));
            //获取输入流
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            //输出流
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            //关闭流
            bis.close();
            bos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return  response;
    }

    /**
     *
     * 根据文件路径删除文件
     * @param request
     * @param response
     * @param src
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, String src){
        response.setCharacterEncoding("utf8");
        String basePath = request.getSession().getServletContext().getRealPath("/");
        if(StringUtils.isEmpty(src)){
            return "src  necessary !";
        }
        //本项目中，文件放到 WEB-INF skin 下
        String fileName = basePath + "WEB-INF/"+ src ;
        File file = new File(fileName);
        if(!file.exists()){//文件不存在
            return "file is not exists!";
        }else{
            // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
            if (file.isFile()) {
                if (file.delete()) {
                    return "success";
                } else {
                    return "system exception !";
                }
            }else{
                return " the deleting is not a file ! ";
            }
        }

    }

}
