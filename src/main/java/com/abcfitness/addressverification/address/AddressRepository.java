package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByClubNumber(String clubNumber);
    Address findById( long id);

//    @Query(value = "SELECT DISTINCT  a.* FROM address a\n" +
//            "    INNER JOIN avalara_response ar ON a.id=ar.address_id\n" +
//            "    inner join avalara_response_message am on ar.id = am.avalara_response_id\n" +
//            "   WHERE a.active = 'Y'", nativeQuery = true)
//    List<Address> findAllInvalid();

    @Query(value = "SELECT aa.* FROM (SELECT DISTINCT a.* FROM address a \n " +
            "   INNER JOIN avalara_response ar ON a.id = ar.address_id \n"  +
            "   INNER JOIN avalara_response_message am on ar.id = am.avalara_response_id) \n" +
            "   as aa where aa.active ='Y'", nativeQuery = true)
    List<Address> findAllInvalid();

}
