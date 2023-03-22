package com.abcfitness.addressverification.address.service;

import com.abcfitness.addressverification.address.feign.smartys.model.Candidate;
import org.modelmapper.ModelMapper;

public class CandidateMapper {

    private final ModelMapper mapper = new ModelMapper();
    private final ComponentsMapper componentsMapper = new ComponentsMapper();
    private final AnalysisMapper analysisMapper = new AnalysisMapper();
    private final MetadataMapper metadataMapper = new MetadataMapper();



    public com.abcfitness.addressverification.address.entity.Candidate toEntity(Candidate candidate){
        com.abcfitness.addressverification.address.entity.Candidate entity = mapper.map(candidate, com.abcfitness.addressverification.address.entity.Candidate.class);
        entity.setAnalysis(analysisMapper.toEntity(candidate.getAnalysis()));
        entity.setMetadata(metadataMapper.toEntity(candidate.getMetadata()));
        entity.setComponents(componentsMapper.toEntity(candidate.getComponents()));
        return entity;
    }

}
