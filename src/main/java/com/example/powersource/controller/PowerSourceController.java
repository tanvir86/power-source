package com.example.powersource.controller;

import com.example.powersource.model.PowerSource;
import com.example.powersource.service.PowerSourceService;
import dto.PowerSourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("/powersource")
public class PowerSourceController {

    @Autowired
    private PowerSourceService powerSourceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PowerSource> create(@Valid @RequestBody PowerSourceDto powerSourceDto){
        return powerSourceService.createPowerSource(powerSourceDto);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<PowerSource> create(@Valid @RequestBody List<PowerSourceDto> powerSourceDtos){
        return powerSourceService.createPowerSource(powerSourceDtos);
    }

    @GetMapping
    public Flux<PowerSource> getAllPowerSources(){
        return powerSourceService.getAllPowerSources();
    }

    @GetMapping("/{powerSourceId}")
    public Mono<ResponseEntity<PowerSource>> getUserById(@Valid @PathVariable @Positive Long powerSourceId){
        Mono<PowerSource> powerSourceMono = powerSourceService.findById(powerSourceId);
        return powerSourceMono.map( u -> ResponseEntity.ok(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}