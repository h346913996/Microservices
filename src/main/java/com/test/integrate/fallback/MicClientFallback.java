package com.test.integrate.fallback;


import com.test.integrate.MicClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MicClientFallback implements FallbackFactory<MicClient> {

    private static Logger LOGGER = LoggerFactory.getLogger(MicClientFallback.class);
    private MicClient micClient;


    public MicClient create(Throwable throwable) {
        LOGGER.error(throwable.getLocalizedMessage());
        return ErrorFallback();
    }

    private MicClient ErrorFallback(){
        return micClient == null?micClient = () ->{
            LOGGER.error("invoke getIndex() failed.");
            return "no such network";
        } : micClient;
    }
}
