package com.abcfitness.addressverification.address;

public class AvalaraResponseNotFoundException extends RuntimeException {
    public AvalaraResponseNotFoundException(Long id) {
        super("Could not find avalara response for address " + id);
    }
}
