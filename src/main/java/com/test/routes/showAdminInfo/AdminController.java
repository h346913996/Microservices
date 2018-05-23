package com.test.routes.showAdminInfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/getAdmin",method = RequestMethod.GET)
public class AdminController {

    public final static String INFO = "用户名：Claude 付款码：---------- 账号：123456789 MicServices_1提供";

    @RequestMapping
    public Object getIndex(){
        return INFO;
    }

}
