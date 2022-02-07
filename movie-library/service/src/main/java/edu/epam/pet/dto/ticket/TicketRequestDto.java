package edu.epam.pet.dto.ticket;

import edu.epam.pet.dto.RequestDto;
import edu.epam.pet.dto.cinemasession.CinemaSessionResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class TicketRequestDto extends RequestDto {

    private BigDecimal cost;

    private int seatRow;

    private int seatPlace;

    private CinemaSessionResponseDto cinemaSessionResponseDto;
}
