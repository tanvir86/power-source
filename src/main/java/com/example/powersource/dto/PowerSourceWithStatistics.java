package com.example.powersource.dto;

import com.example.powersource.model.PowerSource;
import lombok.Data;
import reactor.core.publisher.Flux;

import java.util.List;

@Data
public class PowerSourceWithStatistics {
    private List<PowerSource> powerSources;
    private Double totalWattCapacity;
    private Double averageWattCapacity;
}
