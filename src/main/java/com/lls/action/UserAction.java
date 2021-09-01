package com.lls.action;

import com.lls.pojo.UserEntity;
import com.lls.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author: lls
 * @DateTime: 2021/9/1 15:29
 * @Description: TODO
 */
@Controller
public class UserAction {
    /**
     * 编写两个属性，使用 struts2 的 ognl 表达式可以直接接收到前端过来的数据，不再需要 request.getParameter("xxxx") 接收数据了
     */
    private String username;
    private String password;

    @Autowired
    private UserService userService;

    // get 方法可以不要， set 方法必须有，不然前端的数据就无法注入进来


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * 编写登录控制层方法
     * @return
     */
    public String login() {
        // 打印穿过来的数据
        System.out.println(username + " " + password);
        ActionContext ac = ActionContext.getContext();
        // 得到 servlet 中的三大域的 session 域，在这里我们要将数据保存至 session，并在前端展示
        // 我们可以看到 session 的实质就是一个 map
        Map<String,Object> session = ac.getSession();
        // 登录验证
        UserEntity user = userService.checklogin(username,password);
        if ( user!=null ) {
            session.put("user",username);
            return "success";
        } else {
            return "error";
        }
    }
}
