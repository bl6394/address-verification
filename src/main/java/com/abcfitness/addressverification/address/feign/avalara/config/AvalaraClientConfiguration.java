package com.abcfitness.addressverification.address.feign.avalara.config;

import com.abcfitness.addressverification.address.feign.CustomErrorDecoder;
import feign.Logger;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class AvalaraClientConfiguration {

    @Value("${avalara.account:account}")
    private String account;

    @Value("${avalara.license:license}")
    private String licenseKey;

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user", account);
            requestTemplate.header("password", licenseKey);
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("2006950331", "A9F3C4EE49BBD25F");
    }

}
