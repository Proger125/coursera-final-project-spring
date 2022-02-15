package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.ticket.TicketRequestDto;
import edu.epam.pet.dto.ticket.TicketResponseDto;
import edu.epam.pet.entity.Place;
import edu.epam.pet.entity.Ticket;
import edu.epam.pet.util.ResponseGenerationUtil;
import org.springframework.stereotype.Component;

@Component
public class TicketConverter implements Converter<Ticket, TicketRequestDto, TicketResponseDto> {

    private final ResponseGenerationUtil responseGenerationUtil;

    public TicketConverter(ResponseGenerationUtil responseGenerationUtil) {
        this.responseGenerationUtil = responseGenerationUtil;
    }

    @Override
    public Ticket convertDtoToEntity(TicketRequestDto dto) {
        Ticket ticket = new Ticket();
        ticket.setId(dto.getId());
        Place place = new Place();
        place.setId(dto.getPlaceId());
        ticket.setPlace(place);
        return ticket;
    }

    @Override
    public TicketResponseDto convertEntityToDto(Ticket entity) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setId(entity.getId());
        ticketResponseDto.setCost(entity.getCost());
        ticketResponseDto.setPlace(responseGenerationUtil.createPlaceStringResponse(entity.getPlace()));
        return ticketResponseDto;
    }
}
