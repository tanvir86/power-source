package dto;

import com.example.powersource.model.PowerSource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerSourceDto {
    private Long id;
    @NotNull
    @Size(message = "Name must be between 2 and 25 characters", min = 2, max = 25)
    private String name;
    @Positive
    private int postcode;
    @Positive
    private double capacityInWatt;

    @JsonIgnore
    public PowerSource getPowerSource(){
        return new PowerSource(id,name,postcode,capacityInWatt);
    }
}
