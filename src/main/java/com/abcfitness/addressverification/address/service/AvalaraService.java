package com.abcfitness.addressverification.address.service;

import com.abcfitness.addressverification.address.*;
import com.abcfitness.addressverification.address.entity.Address;
import com.abcfitness.addressverification.address.entity.AvalaraResponse;
import com.abcfitness.addressverification.address.entity.AvalaraResponseMessage;
import com.abcfitness.addressverification.address.feign.avalara.client.AvalaraClient;
import com.abcfitness.addressverification.address.feign.avalara.model.Message;
import com.abcfitness.addressverification.address.feign.avalara.model.ResolveAddress;
import com.abcfitness.addressverification.address.feign.smartys.client.SmartysClient;
import com.abcfitness.addressverification.address.feign.smartys.model.Candidate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvalaraService {

    private final AddressRepository addressRepository;
    private final AvalaraResponseRepository responseRepository;
    private final AvalaraResponseMessageRepository messageRepository;
    private final AvalaraClient avalaraClient;
    private final CandidateMapper candidateMapper = new CandidateMapper();


    public AvalaraService(AddressRepository addressRepository, AvalaraClient avalaraClient, SmartysClient smartysClient, AvalaraResponseRepository avalaraResponseRepository, AvalaraResponseMessageRepository avalaraResponseMessageRepository, CandidateRepository candidateRepository, ComponentsRepository componentsRepository, MetadataRepository metadataRepository, AnalysisRepository analysisRepository){
        this.addressRepository = addressRepository;
        this.avalaraClient = avalaraClient;
        this.responseRepository = avalaraResponseRepository;
        this.messageRepository = avalaraResponseMessageRepository;
    }

    public String doAll() {
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

    public List<AvalaraResponseVO> oneAvalaraResponse(Long id){
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

    public List<AddressVO> findAllInvalid(){
        List<Address> invalidAddresses = addressRepository.findAllInvalid();
        return invalidAddresses.stream().map(element -> new com.abcfitness.addressverification.address.AddressVO(element, messageRepository.findByAddressId(element.getId()))).collect(Collectors.toList());
    }

}
