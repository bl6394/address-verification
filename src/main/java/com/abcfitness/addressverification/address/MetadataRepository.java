package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.Metadata;
import org.springframework.data.repository.CrudRepository;

public interface MetadataRepository extends CrudRepository<Metadata, Long> {
    
}
