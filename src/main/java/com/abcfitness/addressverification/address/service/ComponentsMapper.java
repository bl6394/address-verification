package com.abcfitness.addressverification.address.service;

import com.abcfitness.addressverification.address.feign.smartys.model.Components;
import org.modelmapper.ModelMapper;

public class ComponentsMapper {

    private final ModelMapper mapper = new ModelMapper();

    public com.abcfitness.addressverification.address.entity.Components toEntity(Components components){
        return mapper.map(components, com.abcfitness.addressverification.address.entity.Components.class);
    }

}
