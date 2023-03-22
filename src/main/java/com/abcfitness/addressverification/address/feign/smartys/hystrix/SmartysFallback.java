package com.abcfitness.addressverification.address.feign.smartys.hystrix;

import com.abcfitness.addressverification.address.feign.smartys.client.SmartysClient;
import com.abcfitness.addressverification.address.feign.smartys.model.Candidate;

import java.util.List;

public class SmartysFallback implements SmartysClient {
    @Override
    public List<Candidate> getStreetAddress(String authId, String authToken, String license, String street, String street2, String city, String state, String zipcode, String candidates) {
        return null;
    }
}
