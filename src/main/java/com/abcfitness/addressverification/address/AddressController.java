package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.Address;
import com.abcfitness.addressverification.address.entity.AvalaraResponse;
import com.abcfitness.addressverification.address.entity.AvalaraResponseMessage;
import com.abcfitness.addressverification.address.feign.avalara.client.AvalaraClient;
import com.abcfitness.addressverification.address.feign.avalara.model.Message;
import com.abcfitness.addressverification.address.feign.avalara.model.ResolveAddress;
import com.abcfitness.addressverification.address.feign.smartys.model.Candidate;
import com.abcfitness.addressverification.address.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AddressController {

    private final AddressRepository addressRepository;
    private final AvalaraResponseRepository responseRepository;
    private final AvalaraResponseMessageRepository messageRepository;
    private final AvalaraClient avalaraClient;
    private final AddressService addressService;

    public AddressController(AddressRepository addressRepository, AvalaraClient avalaraClient, AddressService addressService, AvalaraResponseRepository avalaraResponseRepository, AvalaraResponseMessageRepository avalaraResponseMessageRepository){
        this.addressRepository = addressRepository;
        this.avalaraClient = avalaraClient;
        this.responseRepository = avalaraResponseRepository;
        this.messageRepository = avalaraResponseMessageRepository;
        this.addressService = addressService;
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
        List<Address> invalidAddresses = addressRepository.findAllInvalid();
        return invalidAddresses.stream().map(element -> new AddressVO(element, messageRepository.findByAddressId(element.getId()))).collect(Collectors.toList());
    }

    @GetMapping("/addresses/avalaradoall")
    String doAll() {
        Date start = new Date();
        for (Address address : addressRepository.findAll()) {
            if( responseRepository.findByAddressId(address.getId()).isEmpty()){
                ResolveAddress resolveAddress = avalaraClient.getResolveAddress(address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getZip(), "US");
                List<AvalaraResponse> avalaraResponses = responseRepository.findByAddressId(address.getId());
                if (avalaraResponses.isEmpty()){
                    AvalaraResponse avalaraResponse = new AvalaraResponse(address);
                    responseRepository.save(avalaraResponse);
                    for (Message message : resolveAddress.getMessages()){
                        AvalaraResponseMessage avalaraResponseMessage = new AvalaraResponseMessage(message.getSummary(), message.getDetails(), message.getRefersTo(), message.getSeverity(), message.getSource(), avalaraResponse);
                        messageRepository.save(avalaraResponseMessage);
                    }
                }
            }
        }
        Date end = new Date();
        System.out.println("completed in :" + (end.getTime() - start.getTime()) + " milliseconds.");
        return "completed in :" + (end.getTime() - start.getTime()) + " milliseconds.";
    }

    @GetMapping("/addresses/{id}/avalararesponse")
    List<AvalaraResponseVO> oneAvalaraResponse(@PathVariable Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        List<AvalaraResponse> avalaraResponses = responseRepository.findByAddressId(address.getId());
        if(avalaraResponses.isEmpty()){
           throw new AvalaraResponseNotFoundException(id);
       }
       else{
            List<AvalaraResponseVO> responses = new ArrayList<>();
            for (AvalaraResponse avalaraResponse: avalaraResponses){
                responses.add(new AvalaraResponseVO(avalaraResponse.getCreated(), messageRepository.findByAvalaraResponseId(avalaraResponse.getId())));
            }
            return responses;
       }
    }

}
