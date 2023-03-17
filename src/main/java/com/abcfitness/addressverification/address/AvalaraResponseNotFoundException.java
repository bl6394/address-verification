package com.abcfitness.addressverification.address;

public class AvalaraResponseNotFoundException extends RuntimeException {
    AvalaraResponseNotFoundException(Long id) {
        super("Could not find avalara response for address " + id);
    }
}
