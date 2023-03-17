package com.abcfitness.addressverification.client;

import com.abcfitness.addressverification.config.ClientConfiguration;
import com.abcfitness.addressverification.hystrix.AvalaraFallback;
import com.abcfitness.addressverification.model.ResolveAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(   value = "avalara",
                url = "https://sandbox-rest.avatax.com/api/v2",
                configuration = ClientConfiguration.class,
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
