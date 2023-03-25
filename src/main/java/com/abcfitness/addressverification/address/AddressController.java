package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.Address;
import com.abcfitness.addressverification.address.feign.avalara.client.AvalaraClient;
import com.abcfitness.addressverification.address.feign.avalara.model.ResolveAddress;
import com.abcfitness.addressverification.address.feign.smartys.model.Candidate;
import com.abcfitness.addressverification.address.service.AddressService;
import com.abcfitness.addressverification.address.service.AvalaraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private final AddressRepository addressRepository;
    private final AvalaraClient avalaraClient;
    private final AddressService addressService;
    private final AvalaraService avalaraService;

    public AddressController(AddressRepository addressRepository, AvalaraClient avalaraClient, AddressService addressService, AvalaraService avalaraService){
        this.addressRepository = addressRepository;
        this.avalaraClient = avalaraClient;
        this.addressService = addressService;
        this.avalaraService = avalaraService;
    }


    @GetMapping("/addresses/{id}")
    Address one(@PathVariable Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        ResolveAddress resolveAddress = avalaraClient.getResolveAddress(address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getZip(), "US");
        return  address;
    }

    @GetMapping("/addresses/{id}/smartys")
    List<Candidate> oneCandidate(@PathVariable Long id) {
        return addressService.getOneCandidate(id);
    }


    @GetMapping("/addresses/smartysDoAllInvalid")
    String allInvalidSmartys() {
        return addressService.allInvalidSmartys();
    }



    @GetMapping("/addresses/invalid")
    List<AddressVO> findAllInvalid() {
        return avalaraService.findAllInvalid();
    }

    @GetMapping("/addresses/avalaradoall")
    String doAll() {
        return avalaraService.doAll();
    }

    @GetMapping("/addresses/{id}/avalararesponse")
    List<AvalaraResponseVO> oneAvalaraResponse(@PathVariable Long id) {
        return  avalaraService.oneAvalaraResponse(id);
    }

}
