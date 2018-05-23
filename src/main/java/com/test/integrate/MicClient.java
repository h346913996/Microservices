package com.test.integrate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.awt.SunHints;

import java.io.Serializable;

public interface MicClient extends Serializable {

    @RequestMapping( value = "" , method = RequestMethod.GET )
    public String getIndex();

}
