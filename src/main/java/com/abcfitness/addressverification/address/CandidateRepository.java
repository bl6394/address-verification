package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

}
