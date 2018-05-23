package com.test.config;

import com.test.integrate.MicClient;
import com.test.integrate.fallback.MicClientFallback;
import feign.Contract;
import feign.codec.Encoder;
import feign.codec.Decoder;
import feign.hystrix.HystrixFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.Serializable;


@Configuration
@Import(FeignClientsConfiguration.class)
public class MicClientConfig implements Serializable {

    @Value("${extends.url:http://baidu.com}")
    private String url;
    @Value("${extends.serverName:MICSERVICESTEST2}")
    private String serverName;
    private static Logger LOGGER = LoggerFactory.getLogger(MicClientConfig.class);
    @Autowired
    DiscoveryClient discoveryClient;

    @Bean
    @Autowired
    public MicClient bulideMicClient(Encoder encoder, Decoder decoder, Contract contract, MicClientFallback micClientFallback){

        String serverUrl = "http://"
                + discoveryClient.getInstances(serverName).get(0).getHost() + ":"
                + discoveryClient.getInstances(serverName).get(0).getPort()
                + url;
        LOGGER.info("extends.url:{}",serverUrl);
        return HystrixFeign.builder()
                .decoder(decoder)
                .encoder(encoder)
                .contract(contract)
                .target(MicClient.class,serverUrl,micClientFallback);
    }

}
