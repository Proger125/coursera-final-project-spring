package edu.epam.pet.service.impl;

import edu.epam.pet.converter.impl.CinemaSessionConverter;
import edu.epam.pet.dao.CinemaHallDao;
import edu.epam.pet.dao.CinemaSessionDao;
import edu.epam.pet.dao.MovieDao;
import edu.epam.pet.dto.cinemasession.CinemaSessionRequestDto;
import edu.epam.pet.dto.cinemasession.CinemaSessionResponseDto;
import edu.epam.pet.entity.CinemaHall;
import edu.epam.pet.entity.CinemaSession;
import edu.epam.pet.entity.Movie;
import edu.epam.pet.exception.resource.ResourceNotFoundException;
import edu.epam.pet.service.CinemaSessionService;
import edu.epam.pet.util.PlaceGenerationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaSessionServiceImpl implements CinemaSessionService {

    private static final int DEFAULT_ROWS_AMOUNT = 8;

    private static final int DEFAULT_SEATS_IN_ROW_AMOUNT = 20;

    private final CinemaSessionDao cinemaSessionDao;

    private final CinemaSessionConverter cinemaSessionConverter;

    private final MovieDao movieDao;

    private final CinemaHallDao cinemaHallDao;

    private final PlaceGenerationUtil placeGenerationUtil;

    public CinemaSessionServiceImpl(CinemaSessionDao cinemaSessionDao, CinemaSessionConverter cinemaSessionConverter, MovieDao movieDao, CinemaHallDao cinemaHallDao, PlaceGenerationUtil placeGenerationUtil) {
        this.cinemaSessionDao = cinemaSessionDao;
        this.cinemaSessionConverter = cinemaSessionConverter;
        this.movieDao = movieDao;
        this.cinemaHallDao = cinemaHallDao;
        this.placeGenerationUtil = placeGenerationUtil;
    }

    @Override
    @Transactional
    public CinemaSessionResponseDto save(CinemaSessionRequestDto dto) {
        CinemaSession cinemaSession = cinemaSessionConverter.convertDtoToEntity(dto);

        Long movieId = cinemaSession.getMovie().getId();
        Optional<Movie> optionalMovie = movieDao.findById(movieId);
        if (optionalMovie.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + movieId, movieId);
        }
        cinemaSession.setMovie(optionalMovie.get());

        Long cinemaHallId = cinemaSession.getCinemaHall().getId();
        Optional<CinemaHall> optionalCinemaHall = cinemaHallDao.findById(cinemaHallId);
        if (optionalCinemaHall.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + cinemaHallId, cinemaHallId);
        }
        cinemaSession.setCinemaHall(optionalCinemaHall.get());
        cinemaSession.setPlaces(placeGenerationUtil.generateEmptyPlaces(DEFAULT_ROWS_AMOUNT, DEFAULT_SEATS_IN_ROW_AMOUNT, cinemaSession));
        return cinemaSessionConverter.convertEntityToDto(cinemaSessionDao.save(cinemaSession));
    }

    @Override
    public CinemaSessionResponseDto findById(Long id) {
        Optional<CinemaSession> optionalCinemaSession = cinemaSessionDao.findById(id);
        if (optionalCinemaSession.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + id, id);
        }
        return cinemaSessionConverter.convertEntityToDto(optionalCinemaSession.get());
    }

    @Override
    public Page<CinemaSessionResponseDto> findAll(Pageable pageable) {
        return new PageImpl<>(
                cinemaSessionDao
                        .findAll(pageable)
                        .stream()
                        .map(cinemaSessionConverter::convertEntityToDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<CinemaSession> optionalCinemaSession = cinemaSessionDao.findById(id);
        if (optionalCinemaSession.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found by id: " + id, id);
        }
        cinemaSessionDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cinemaSessionDao.deleteAll();
    }
}
