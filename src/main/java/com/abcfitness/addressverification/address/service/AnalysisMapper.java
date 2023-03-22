package com.abcfitness.addressverification.address.service;

import com.abcfitness.addressverification.address.feign.smartys.model.Analysis;
import org.modelmapper.ModelMapper;

public class AnalysisMapper {

    private final ModelMapper mapper = new ModelMapper();

    public com.abcfitness.addressverification.address.entity.Analysis toEntity(Analysis analysis){
        return mapper.map(analysis, com.abcfitness.addressverification.address.entity.Analysis.class);
    }

}
