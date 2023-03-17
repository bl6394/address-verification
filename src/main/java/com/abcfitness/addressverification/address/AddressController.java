package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.Address;
import com.abcfitness.addressverification.address.entity.AvalaraResponse;
import com.abcfitness.addressverification.address.entity.AvalaraResponseMessage;
import com.abcfitness.addressverification.address.entity.Corrected;
import com.abcfitness.addressverification.client.AvalaraClient;
import com.abcfitness.addressverification.model.Message;
import com.abcfitness.addressverification.model.ResolveAddress;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AddressController {

    private final AddressRepository addressRepository;
    private final AvalaraResponseRepository responseRepository;
    private final AvalaraResponseMessageRepository messageRepository;
    private final CorrectedRepository correctedRepository;
    private final AvalaraClient avalaraClient;

    public AddressController( AddressRepository addressRepository, AvalaraClient avalaraClient, AvalaraResponseRepository avalaraResponseRepository, AvalaraResponseMessageRepository avalaraResponseMessageRepository, CorrectedRepository correctedRepository){
        this.addressRepository = addressRepository;
        this.avalaraClient = avalaraClient;
        this.responseRepository = avalaraResponseRepository;
        this.messageRepository = avalaraResponseMessageRepository;
        this.correctedRepository = correctedRepository;
    }


    @GetMapping("/addresses/{id}")
    Address one(@PathVariable Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        ResolveAddress resolveAddress = avalaraClient.getResolveAddress(address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getZip(), "US");
        return  address;
    }

    @GetMapping("/addresses/{id}/avalara")
    ResolveAddress oneAvalara(@PathVariable Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        ResolveAddress resolveAddress;
        if ( address.getCorrected() == null ) {
            resolveAddress = avalaraClient.getResolveAddress(address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getZip(), "US");
        } else {
            Corrected corrected = address.getCorrected();
            resolveAddress = avalaraClient.getResolveAddress( corrected.getLine1() == null ? address.getLine1() : corrected.getLine1(),
                                                                        corrected.getLine1() == null ? address.getLine2() : corrected.getLine2(),
                                                                        corrected.getCity() == null ? address.getCity() : corrected.getCity(),
                                                                        corrected.getState() == null ? address.getState() : corrected.getState(),
                                                                        corrected.getZip() == null ? address.getZip() : corrected.getZip(),
                                                                "US");
        }
        List<AvalaraResponse> avalaraResponses = responseRepository.findByAddressId(address.getId());
        if (avalaraResponses.isEmpty()){
            AvalaraResponse avalaraResponse = new AvalaraResponse(address);
            responseRepository.save(avalaraResponse);
            for (Message message : resolveAddress.getMessages()){
                AvalaraResponseMessage avalaraResponseMessage = new AvalaraResponseMessage(message.getSummary(), message.getDetails(), message.getRefersTo(), message.getSeverity(), message.getSource(), avalaraResponse);
                messageRepository.save(avalaraResponseMessage);
            }
        }
        return resolveAddress;
    }

    @GetMapping("/addresses/invalid")
    List<AddressVO> findAllInvalid() {
        List<Address> invalidAddresses = addressRepository.findAllInvalid();
        return invalidAddresses.stream().map(element -> new AddressVO(element, messageRepository.findByAddressId(element.getId()), correctedRepository.findById(element.getId()).orElse(null))).collect(Collectors.toList()) ;
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

    @PostMapping("/addresses/{id}/corrected")
    Address createCorrected(@PathVariable Long id, @RequestBody Corrected corrected){
        Optional<Address> result = addressRepository.findById(id);
        Address address = result.get();
        address.setCorrected(corrected);
        return addressRepository.save(address);
    }
}
