package com.abcfitness.addressverification.address.feign.smartys.client;

import com.abcfitness.addressverification.address.feign.avalara.config.AvalaraClientConfiguration;
import com.abcfitness.addressverification.address.feign.smartys.hystrix.SmartysFallback;
import com.abcfitness.addressverification.address.feign.smartys.model.Candidate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(   value = "smartys",
                url = "https://us-street.api.smartystreets.com",
                configuration = AvalaraClientConfiguration.class,
                fallback = SmartysFallback.class)
public interface SmartysClient {


    @RequestMapping(method = RequestMethod.GET, value = "/street-address")
    List<Candidate> getStreetAddress(
            @RequestParam("auth-id") String authId,
            @RequestParam("auth-token") String authToken,
            @RequestParam("license") String license,
            @RequestParam("street") String street,
            @RequestParam("street2") String street2,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("zipcode") String zipcode,
            @RequestParam("candidates") String candidates
            );

}
