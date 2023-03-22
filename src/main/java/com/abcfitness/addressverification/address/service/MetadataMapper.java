package com.abcfitness.addressverification.address.service;

import com.abcfitness.addressverification.address.feign.smartys.model.Metadata;
import org.modelmapper.ModelMapper;

public class MetadataMapper {

    private final ModelMapper mapper = new ModelMapper();

    public com.abcfitness.addressverification.address.entity.Metadata toEntity(Metadata metadata){
        return mapper.map(metadata, com.abcfitness.addressverification.address.entity.Metadata.class);
    }

}
