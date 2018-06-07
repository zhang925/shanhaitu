package com.sht.restcontroller;

import com.sht.entity.order.OrderEntity;
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

@RestController
@RequestMapping("/order")
/**
 *  订单外部接口
 */
public class OrderRestController {

    @Autowired
    private SystemService systemService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg list(OrderEntity orderEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<OrderEntity> list = new ArrayList<OrderEntity>();
        list = systemService.getList(OrderEntity.class);
        //

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(list);
        return ajaxMsg;
    }


    /**根据用户的ID获取用户的全部订单*/
    @RequestMapping(value = "/user/list",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg userList(OrderEntity orderEntity, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<OrderEntity> list = new ArrayList<OrderEntity>();
        //对用户ID校验
        if(orderEntity==null || orderEntity.getUserid()==null || "".equals(orderEntity.getUserid()) ){
            ajaxMsg.setMsg("用户的ID不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
            return ajaxMsg;
        }
       String userid = orderEntity.getUserid();//用户ID
        list = systemService.findHql(" from OrderEntity where userid = ? ",new Object[]{userid} );
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(list);
        return ajaxMsg;
    }


    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg info(@PathVariable String id, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        OrderEntity orderEntity = new OrderEntity();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
        }
        orderEntity = systemService.getEntity(OrderEntity.class,id);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(orderEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg save(OrderEntity orderEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();

        //订单ID动态生成
        if(orderEntity==null || orderEntity.getUserid()==null || "".equals(orderEntity.getUserid()) ){
            ajaxMsg.setMsg("用户的ID不能为空");
            ajaxMsg.setResponsecode(HttpStatus.NOT_FOUND.value());
            return ajaxMsg;
        }
        String orderid = UtilSht.createOrderIDByUserID(orderEntity.getUserid());
        if(StringUtil.isEmpty(orderid)){
            ajaxMsg.setMsg("系统错误,保存失败。");
            ajaxMsg.setResponsecode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ajaxMsg;
        }
        orderEntity.setOrderid(orderid);//生成订单ID
        systemService.save(orderEntity);
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(orderEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg update(OrderEntity orderEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(orderEntity==null  || orderEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
        }
        systemService.updateEntitie(orderEntity);
        //
        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        ajaxMsg.setModel(orderEntity);
        return ajaxMsg;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg delete(OrderEntity orderEntity,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        if(orderEntity==null  || orderEntity.getId()==null){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        //判断该实体是否存在
        OrderEntity temp = systemService.getEntity(OrderEntity.class,orderEntity.getId());
        if(temp==null || temp.getId()==null){
            ajaxMsg.setMsg("该实体不存在！");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        systemService.deleteEntityById(OrderEntity.class,orderEntity.getId());

        ajaxMsg.setMsg("success");
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

}

