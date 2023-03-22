package com.abcfitness.addressverification.address.feign.avalara.hystrix;

import com.abcfitness.addressverification.address.feign.avalara.client.AvalaraClient;
import com.abcfitness.addressverification.address.feign.avalara.model.ResolveAddress;

public class AvalaraFallback implements AvalaraClient {
    @Override
    public ResolveAddress getResolveAddress(String line1, String line2, String city, String region, String postalCode, String country) {
        return null;
    }
}
