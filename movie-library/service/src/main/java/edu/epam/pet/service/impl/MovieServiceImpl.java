package edu.epam.pet.service.impl;

import edu.epam.pet.converter.impl.MovieConverter;
import edu.epam.pet.dao.ActorDao;
import edu.epam.pet.dao.MovieDao;
import edu.epam.pet.dto.movie.MovieRequestDto;
import edu.epam.pet.dto.movie.MovieResponseDto;
import edu.epam.pet.entity.Actor;
import edu.epam.pet.entity.Movie;
import edu.epam.pet.exception.resource.ResourceNotFoundException;
import edu.epam.pet.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    private final ActorDao actorDao;

    private final MovieConverter movieConverter;

    public MovieServiceImpl(MovieDao movieDao, ActorDao actorDao, MovieConverter movieConverter) {
        this.movieDao = movieDao;
        this.actorDao = actorDao;
        this.movieConverter = movieConverter;
    }

    @Override
    @Transactional
    public MovieResponseDto save(MovieRequestDto dto) {
        Movie movie = movieConverter.convertDtoToEntity(dto);
        for (var actor : movie.getActors()) {
            Optional<Actor> optionalActor = actorDao.findActorByFirstNameAndLastNameAndBirthDate(
                    actor.getFirstName(),
                    actor.getLastName(),
                    actor.getBirthDate());
            if (optionalActor.isPresent()) {
                actor.setId(optionalActor.get().getId());
            } else {
                actorDao.save(actor);
            }
        }
        return movieConverter.convertEntityToDto(movieDao.save(movie));
    }

    @Override
    public MovieResponseDto findById(Long id) {
        Optional<Movie> optionalMovie = movieDao.findById(id);
        if (optionalMovie.isEmpty()) {
            throw new ResourceNotFoundException("Movie not found by id: " + id, id);
        }
        return movieConverter.convertEntityToDto(optionalMovie.get());
    }

    @Override
    public Page<MovieResponseDto> findAll(Pageable pageable) {
        return new PageImpl<>(
                movieDao.findAll(pageable)
                        .stream().map(movieConverter::convertEntityToDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public void deleteById(Long id) {
        Optional<Movie> optionalMovie = movieDao.findById(id);
        if (optionalMovie.isEmpty()) {
            throw new ResourceNotFoundException("Actor not found by id: " + id, id);
        }
        movieDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        actorDao.deleteAll();
    }
}
