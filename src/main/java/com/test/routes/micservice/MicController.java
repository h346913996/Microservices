package com.test.routes.micservice;

import com.test.integrate.MicClient;
import com.test.routes.showAdminInfo.AdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin-order",method = RequestMethod.GET)
public class MicController {

    @Autowired
    private MicClient micClient;

    @RequestMapping
    public Object getIndex(){
        return AdminController.INFO + "<br>"
                +micClient.getIndex();
    }

}
