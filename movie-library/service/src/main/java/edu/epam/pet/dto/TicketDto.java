package edu.epam.pet.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class TicketDto extends Dto{

    private BigDecimal cost;

    private PlaceDto placeDto;
}
