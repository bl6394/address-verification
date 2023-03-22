package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.AvalaraResponseMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvalaraResponseMessageRepository extends CrudRepository<AvalaraResponseMessage, Long> {

    List<AvalaraResponseMessage> findByAvalaraResponseId(long id);
    AvalaraResponseMessage findById(long id);

    @Query(nativeQuery = true, value = "SELECT am.* FROM address a INNER JOIN avalara_response ar ON a.id = ar.address_id INNER JOIN avalara_response_message am on ar.id = am.avalara_response_id where a.id = :addressId ")
    List<AvalaraResponseMessage> findByAddressId(@Param("addressId") Long addressId);
}
