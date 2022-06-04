package com.example.powersource.service;

import com.example.powersource.model.PowerSource;
import com.example.powersource.repository.PowerSourceRepository;
import dto.PowerSourceDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class PowerSourceService {

    @Autowired
    private PowerSourceRepository powerSourceRepository;

    public Mono<PowerSource> createPowerSource(PowerSourceDto powerSourceDto) {
        return powerSourceRepository.save(powerSourceDto.getPowerSource());
    }

    public Flux<PowerSource> createPowerSource(List<PowerSourceDto> powerSourceDtos) {
        return powerSourceRepository.saveAll(powerSourceDtos
                .stream()
                .map(PowerSourceDto::getPowerSource)
                .collect(Collectors.toList())
        );
    }


    public Flux<PowerSource> getAllPowerSources() {
        return powerSourceRepository.findAll();
    }

    public Mono<PowerSource> findById(Long powerSourceId) {
        return powerSourceRepository.findById(powerSourceId);
    }

}