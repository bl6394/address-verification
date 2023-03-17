package com.abcfitness.addressverification.address;

import static org.assertj.core.api.Assertions.assertThat;

import com.abcfitness.addressverification.address.entity.Address;
import com.abcfitness.addressverification.address.entity.AvalaraResponse;
import com.abcfitness.addressverification.address.entity.AvalaraResponseMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    AddressRepository addresses;

    @Autowired
    AvalaraResponseRepository avalaraResponseRepository;

    @Autowired
    AvalaraResponseMessageRepository avalaraResponseMessageRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void testFind() {
        Address address = new Address("HyperFitness","01002", "Y","2806 Woodlake Ct.", "", "Highland Village", "TX", "75077", "0000");
        AvalaraResponse avalaraResponse = new AvalaraResponse(address);
        AvalaraResponseMessage avalaraResponseMessage1 = new AvalaraResponseMessage("summary1", "details1", "reference1" ,"severity1", "source1", avalaraResponse);
        AvalaraResponseMessage avalaraResponseMessage2 = new AvalaraResponseMessage("summary2", "details2", "reference2" ,"severity2", "source2", avalaraResponse);

        entityManager.persist(address);
        entityManager.persist(avalaraResponse);
        entityManager.persist(avalaraResponseMessage1);
        entityManager.persist(avalaraResponseMessage2);

        List<Address> byClubNumber = addresses.findByClubNumber("01002");
        assertThat(byClubNumber.size()).isEqualTo(1);
        List<AvalaraResponse> avalaraResponses = avalaraResponseRepository.findByAddressId(byClubNumber.get(0).getId());
        assertThat(avalaraResponses.size()).isEqualTo(1);
        List<AvalaraResponseMessage> byAvalaraResponseId = avalaraResponseMessageRepository.findByAvalaraResponseId(avalaraResponses.get(0).getId());
        assertThat(byAvalaraResponseId.size()).isEqualTo(2);
    }

}