package com.abcfitness.addressverification.address.feign.avalara.client;

import com.abcfitness.addressverification.address.feign.avalara.config.AvalaraClientConfiguration;
import com.abcfitness.addressverification.address.feign.avalara.hystrix.AvalaraFallback;
import com.abcfitness.addressverification.address.feign.avalara.model.ResolveAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(   value = "avalara",
                url = "https://sandbox-rest.avatax.com/api/v2",
                configuration = AvalaraClientConfiguration.class,
                fallback = AvalaraFallback.class)
public interface AvalaraClient {


    @RequestMapping(method = RequestMethod.GET, value = "/addresses/resolve")
    ResolveAddress getResolveAddress(
            @RequestParam("line1") String line1,
            @RequestParam("line2") String line2,
            @RequestParam("city") String city,
            @RequestParam("region") String region,
            @RequestParam("postalCode") String postalCode,
            @RequestParam("country") String country
            );

}
