package com.example.powersource.repository;

import com.example.powersource.model.PowerSource;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PowerSourceRepository extends ReactiveCrudRepository<PowerSource, Long> {


}