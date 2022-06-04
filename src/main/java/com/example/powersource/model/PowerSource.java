package com.example.powersource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("sources")
public class PowerSource {
    @Id
    @Column("id")
    private Long id;
    private String name;
    private int postcode;

    @Column("capacity_in_watt")
    private double capacityInWatt;
}
