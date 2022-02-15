package edu.epam.pet.dto.ticket;

import edu.epam.pet.dto.Dto;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class TicketRequestDto extends Dto {

    @Min(1)
    private Long placeId;
}
