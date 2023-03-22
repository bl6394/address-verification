package com.abcfitness.addressverification.address;

public class AddressNotFoundException extends RuntimeException  {
    public AddressNotFoundException(Long id) {
        super("Could not find employee " + id);
    }

}
