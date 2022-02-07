package edu.epam.pet.dto.ticket;

import edu.epam.pet.dto.ResponseDto;
import edu.epam.pet.dto.place.PlaceResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class TicketResponseDto extends ResponseDto {

    private BigDecimal cost;

    private PlaceResponseDto placeResponseDto;
}
