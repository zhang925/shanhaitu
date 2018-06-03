package com.sht.restcontroller.tempentity;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class AjaxMsg {

    private Object responsecode = 200 ;// 是否成功
    private Object model = null;// 其他信息
    private Object msg = "";

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(Object responsecode) {
        this.responsecode = responsecode;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    /*public String getJsonStr(){
        JSONObject obj = new JSONObject();
        obj.put("responsecode", this.responsecode);
        obj.put("model", this.model);
        return obj.toJSONString();
    }*/

}
