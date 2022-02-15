package edu.epam.pet.service.impl;

import edu.epam.pet.converter.impl.TicketConverter;
import edu.epam.pet.dao.PlaceDao;
import edu.epam.pet.dao.TicketDao;
import edu.epam.pet.dto.ticket.TicketRequestDto;
import edu.epam.pet.dto.ticket.TicketResponseDto;
import edu.epam.pet.entity.Place;
import edu.epam.pet.entity.Ticket;
import edu.epam.pet.exception.resource.ResourceNotFoundException;
import edu.epam.pet.exception.resource.TakenPlaceException;
import edu.epam.pet.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketConverter ticketConverter;

    private final TicketDao ticketDao;

    private final PlaceDao placeDao;

    public TicketServiceImpl(TicketConverter ticketConverter, TicketDao ticketDao, PlaceDao placeDao) {
        this.ticketConverter = ticketConverter;
        this.ticketDao = ticketDao;
        this.placeDao = placeDao;
    }

    @Override
    public TicketResponseDto save(TicketRequestDto dto) {
        Ticket ticket = ticketConverter.convertDtoToEntity(dto);
        Long placeId = ticket.getPlace().getId();
        Optional<Place> optionalPlace = placeDao.findById(placeId);
        if (optionalPlace.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + placeId, placeId);
        }
        Place place = optionalPlace.get();
        if (place.isTaken()) {
            throw new TakenPlaceException("This place is already taken");
        }
        place.setTaken(true);
        ticket.setPlace(optionalPlace.get());
        ticket.setCost(place.getCinemaSession().getCinemaHall().getOnePlaceCost());
        return ticketConverter.convertEntityToDto(ticketDao.save(ticket));
    }

    @Override
    public TicketResponseDto findById(Long id) {
        Optional<Ticket> optionalTicket = ticketDao.findById(id);
        if (optionalTicket.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + id, id);
        }
        return ticketConverter.convertEntityToDto(optionalTicket.get());
    }

    @Override
    public Page<TicketResponseDto> findAll(Pageable pageable) {
        return new PageImpl<>(
                ticketDao
                        .findAll(pageable)
                        .stream()
                        .map(ticketConverter::convertEntityToDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public void deleteById(Long id) {
        Optional<Ticket> optionalTicket = ticketDao.findById(id);
        if (optionalTicket.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + id, id);
        }
        ticketDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        ticketDao.deleteAll();
    }
}
