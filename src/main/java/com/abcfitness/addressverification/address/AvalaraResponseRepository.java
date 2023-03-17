package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.AvalaraResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvalaraResponseRepository extends CrudRepository<AvalaraResponse, Long> {

    List<AvalaraResponse> findByAddressId(long id);
    AvalaraResponse findById(long id);
}
