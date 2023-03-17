package com.abcfitness.addressverification.address;

class AddressNotFoundException extends RuntimeException  {
    AddressNotFoundException(Long id) {
        super("Could not find employee " + id);
    }

}
