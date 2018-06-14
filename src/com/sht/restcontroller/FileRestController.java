package com.sht.restcontroller;

import com.sht.entity.fileinfo.FileInfoEntity;
import com.sht.restcontroller.tempentity.AjaxMsg;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传下载的 公用类
 */
@RestController
@RequestMapping("/file")
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
     * 从map中赋值 fileInfo
     * @param map
     * @return
     */
    public FileInfoEntity getFileInfoEntity(Map map){
        FileInfoEntity fileInfoEntity = new FileInfoEntity();
        if(map!=null){
            Object modular = map.get("modular");
            if(StringUtil.isNotEmpty(modular)){
                fileInfoEntity.setModular(modular.toString());
            }
            Object className = map.get("className");
            if(StringUtil.isNotEmpty(className)){
                fileInfoEntity.setClassName(className.toString());
            }
            Object tableName = map.get("tableName");
            if(StringUtil.isNotEmpty(tableName)){
                fileInfoEntity.setTableName(tableName.toString());
            }
            Object columnid = map.get("columnid");
            if(StringUtil.isNotEmpty(columnid)){
                fileInfoEntity.setColumnid(columnid.toString());
            }
        }
        return fileInfoEntity;
    }

    /**
     *  上传 调研报告相关图集
     */
    @RequestMapping(value = "/upload/report/images", method = RequestMethod.POST)
    public void uploadReportImages(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map map = new HashMap();
        map.put("modular","report/images");
        map.put("className","");
        map.put("tableName","");
        map.put("columnid","");
        uploadFile( file,  map,  request,  response);
    }

    /**
     *  上传 调研报告相关图集
     */
    @RequestMapping(value = "/upload/report/doc", method = RequestMethod.POST)
    public void uploadReportDoc(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map map = new HashMap();
        map.put("modular","report/doc");
        map.put("className","");
        map.put("tableName","");
        map.put("columnid","");
        uploadFile( file,  map,  request,  response);
    }






    /**
     *  上传
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file") CommonsMultipartFile file, Map map, HttpServletRequest request, HttpServletResponse response){
        //FileInfoEntity fileInfoEntity = getFileInfoEntity(map);//初始化 文件信息实体
        Object addTempPath = map.get("modular").toString();
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
            String addPath= "/uploadfile/"+addTempPath+"/"+timestr+"/"+sd2.format(new Date())+originname;
            String path = basePath + addPath;
            File newFile=new File(path);
            if(!newFile.exists()){
                newFile.mkdirs();
            }
            file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
            resMsg =  addPath.replace("WEB-INF/","");
            response.setCharacterEncoding("UTF8");
            response.getWriter().write(resMsg);
        } catch (Exception e) {
            e.printStackTrace();
            resMsg = "error";
        }

    }


    @RequestMapping(value = "/upload3", method = RequestMethod.POST)
    public String upload(DataHandler handler, String fileName) {
        if (fileName != null && !"".equals(fileName)) {
            File file = new File(fileName);
            if (handler != null) {
                InputStream is = null;
                FileOutputStream fos = null;
                try {
                    is = handler.getInputStream();
                    fos = new FileOutputStream(file);
                    byte[] buff = new byte[1024 * 8];
                    int len = 0;
                    while ((len = is.read(buff)) > 0) {
                        fos.write(buff, 0, len);
                    }
                } catch (FileNotFoundException e) {
                    return "fileNotFound";
                } catch (Exception e) {
                    return "upload File failure";
                } finally {
                    try {
                        if (fos != null) {
                            fos.flush();
                            fos.close();
                        }
                        if (is != null) {
                            is.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return "file absolute path:" + file.getAbsolutePath();
            } else {
                return "handler is null";
            }
        } else {
            return "fileName is null";
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
        // storeName 类似  uploadfile/noticefile/20180604/20180604114710QQ截图.png
        String basePath = request.getSession().getServletContext().getRealPath("/");//
        downLoadPath =  basePath +"/" +src ;
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
        String fileName = basePath + "/"+ src ;
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
