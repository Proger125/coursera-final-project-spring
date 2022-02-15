package edu.epam.pet.dto.ticket;

import edu.epam.pet.dto.Dto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class TicketResponseDto extends Dto {

    private BigDecimal cost;

    private String place;
}
