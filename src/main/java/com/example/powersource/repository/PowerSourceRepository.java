package com.example.powersource.repository;

import com.example.powersource.model.PowerSource;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PowerSourceRepository extends ReactiveCrudRepository<PowerSource, Long> {
    @Query("select * from sources where postcode between :fromPostCode and :toPostCode order by name")
    public Flux<PowerSource> getPowerSourceByPostCodeRange(Integer fromPostCode, Integer toPostCode);

}