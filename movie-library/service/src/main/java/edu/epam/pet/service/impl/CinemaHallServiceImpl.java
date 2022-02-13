package edu.epam.pet.service.impl;

import edu.epam.pet.converter.impl.CinemaHallConverter;
import edu.epam.pet.dao.CinemaDao;
import edu.epam.pet.dao.CinemaHallDao;
import edu.epam.pet.dto.cinemahall.CinemaHallRequestDto;
import edu.epam.pet.dto.cinemahall.CinemaHallResponseDto;
import edu.epam.pet.entity.Cinema;
import edu.epam.pet.entity.CinemaHall;
import edu.epam.pet.exception.resource.ResourceNotFoundException;
import edu.epam.pet.service.CinemaHallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallConverter cinemaHallConverter;

    private final CinemaHallDao cinemaHallDao;

    private final CinemaDao cinemaDao;

    public CinemaHallServiceImpl(CinemaHallConverter cinemaHallConverter, CinemaHallDao cinemaHallDao, CinemaDao cinemaDao) {
        this.cinemaHallConverter = cinemaHallConverter;
        this.cinemaHallDao = cinemaHallDao;
        this.cinemaDao = cinemaDao;
    }

    @Override
    @Transactional
    public CinemaHallResponseDto save(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = cinemaHallConverter.convertDtoToEntity(dto);
        Long cinemaId = cinemaHall.getCinema().getId();
        Optional<Cinema> optionalCinema = cinemaDao.findById(cinemaId);
        if (optionalCinema.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + cinemaId, cinemaId);
        }
        Cinema cinema = optionalCinema.get();
        cinemaHall.setNumber(cinema.getHalls().size() + 1);
        cinemaHall.setCinema(cinema);
        return cinemaHallConverter.convertEntityToDto(cinemaHallDao.save(cinemaHall));
    }

    @Override
    public CinemaHallResponseDto findById(Long id) {
        Optional<CinemaHall> optionalCinemaHall = cinemaHallDao.findById(id);
        if (optionalCinemaHall.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + id, id);
        }
        CinemaHall cinemaHall = optionalCinemaHall.get();
        return cinemaHallConverter.convertEntityToDto(cinemaHall);
    }

    @Override
    public Page<CinemaHallResponseDto> findAll(Pageable pageable) {
        return new PageImpl<>(
                cinemaHallDao.findAll(pageable).stream().map(cinemaHallConverter::convertEntityToDto).collect(Collectors.toList())
        );
    }

    @Override
    public void deleteById(Long id) {
        Optional<CinemaHall> optionalCinemaHall = cinemaHallDao.findById(id);
        if (optionalCinemaHall.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + id, id);
        }
        cinemaHallDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cinemaHallDao.deleteAll();
    }
}
