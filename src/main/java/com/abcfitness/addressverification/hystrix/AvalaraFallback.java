package com.abcfitness.addressverification.hystrix;

import com.abcfitness.addressverification.client.AvalaraClient;
import com.abcfitness.addressverification.model.ResolveAddress;

public class AvalaraFallback implements AvalaraClient {
    @Override
    public ResolveAddress getResolveAddress(String line1, String line2, String city, String region, String postalCode, String country) {
        return null;
    }
}
