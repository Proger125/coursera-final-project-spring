package edu.epam.pet.service.impl;

import edu.epam.pet.converter.impl.CinemaConverter;
import edu.epam.pet.dao.CinemaDao;
import edu.epam.pet.dto.cinema.CinemaRequestDto;
import edu.epam.pet.dto.cinema.CinemaResponseDto;
import edu.epam.pet.entity.Cinema;
import edu.epam.pet.exception.resource.ResourceNotFoundException;
import edu.epam.pet.service.CinemaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaConverter cinemaConverter;

    private final CinemaDao cinemaDao;

    public CinemaServiceImpl(CinemaConverter cinemaConverter, CinemaDao cinemaDao) {
        this.cinemaConverter = cinemaConverter;
        this.cinemaDao = cinemaDao;
    }

    @Override
    public CinemaResponseDto save(CinemaRequestDto dto) {
        Cinema cinema = cinemaConverter.convertDtoToEntity(dto);
        cinema = cinemaDao.save(cinema);
        return cinemaConverter.convertEntityToDto(cinema);
    }

    @Override
    public CinemaResponseDto findById(Long id) {
        Optional<Cinema> optionalCinema = cinemaDao.findById(id);
        if (optionalCinema.isEmpty()) {
            throw new ResourceNotFoundException("Cinema not found by id: " + id, id);
        }
        Cinema cinema = optionalCinema.get();
        return cinemaConverter.convertEntityToDto(cinema);
    }

    @Override
    public Page<CinemaResponseDto> findAll(Pageable pageable) {
        return new PageImpl<>(
                cinemaDao.findAll(pageable)
                        .stream()
                        .map(cinemaConverter::convertEntityToDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public void deleteById(Long id) {
        Optional<Cinema> optionalCinema = cinemaDao.findById(id);
        if (optionalCinema.isEmpty()) {
            throw new ResourceNotFoundException("Cinema not found by id: " + id, id);
        }
        cinemaDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cinemaDao.deleteAll();
    }
}
