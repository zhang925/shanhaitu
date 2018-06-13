package com.sht.restcontroller.tempentity;

import org.springframework.http.HttpStatus;

public class AjaxMsgFactory {
    public static <T> AjaxMsg createSuccessMsg(T model) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(model);

        return ajaxMsg;
    }

    public static <T> AjaxMsg createErrorMsg(T model, HttpStatus httpStatus, String errMsg) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        ajaxMsg.setMsg(errMsg);
        ajaxMsg.setResponsecode(httpStatus.value());
        ajaxMsg.setModel(model);

        return ajaxMsg;
    }
}
