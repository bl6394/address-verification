package com.abcfitness.addressverification.address.service;

import com.abcfitness.addressverification.address.*;
import com.abcfitness.addressverification.address.entity.Address;
import com.abcfitness.addressverification.address.feign.avalara.client.AvalaraClient;
import com.abcfitness.addressverification.address.feign.smartys.client.SmartysClient;
import com.abcfitness.addressverification.address.feign.smartys.model.Candidate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartysService {

    @Value("${smartys.authid:default}")
    private String authId;

    @Value("${smartys.authtoken:token}")
    private String authToken;

    @Value("${smartys.license:license}")
    private String license;

    private final AddressRepository addressRepository;
    private final AvalaraResponseRepository responseRepository;
    private final AvalaraResponseMessageRepository messageRepository;
    private final CandidateRepository candidateRepository;
    private final AnalysisRepository analysisRepository;
    private final MetadataRepository metadataRepository;
    private final ComponentsRepository componentsRepository;
    private final AvalaraClient avalaraClient;
    private final SmartysClient smartysClient;
    private final CandidateMapper candidateMapper = new CandidateMapper();


    public SmartysService(AddressRepository addressRepository, AvalaraClient avalaraClient, SmartysClient smartysClient, AvalaraResponseRepository avalaraResponseRepository, AvalaraResponseMessageRepository avalaraResponseMessageRepository, CandidateRepository candidateRepository, ComponentsRepository componentsRepository, MetadataRepository metadataRepository, AnalysisRepository analysisRepository){
        this.addressRepository = addressRepository;
        this.avalaraClient = avalaraClient;
        this.responseRepository = avalaraResponseRepository;
        this.messageRepository = avalaraResponseMessageRepository;
        this.smartysClient = smartysClient;
        this.candidateRepository = candidateRepository;
        this.componentsRepository = componentsRepository;
        this.metadataRepository = metadataRepository;
        this.analysisRepository = analysisRepository;
    }


    public List<Candidate> getOneCandidate(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        List<Candidate>  candidates;
        candidates = smartysClient.getStreetAddress(authId, authToken, license, address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getZip(), "10");
        for (Candidate candidateVO : candidates){
            com.abcfitness.addressverification.address.entity.Candidate entity = candidateMapper.toEntity(candidateVO);
            candidateRepository.save(entity);
        }
        return candidates;
    }

    public String allInvalidSmartys() {
        List<Address> addresses = addressRepository.findAllInvalid();
        for (Address address: addresses){
            List<Candidate>  candidates;
            candidates = smartysClient.getStreetAddress("96fcbeab-b6a5-a22d-91c8-08f1242ebc20", "TjPg6FoDm5p76ss6K3Dh", "us-rooftop-geocoding-cloud", address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getZip(), "10");
            for (Candidate candidateVO : candidates){
                com.abcfitness.addressverification.address.entity.Candidate entity = candidateMapper.toEntity(candidateVO);
                entity.setAddress(address);
                candidateRepository.save(entity);
            }
        }
        return "finished";

    }
}
