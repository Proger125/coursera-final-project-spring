package edu.epam.pet.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class TicketDto extends Dto{

    @Min(1)
    private BigDecimal cost;

    @NotNull
    private PlaceDto placeDto;
}
