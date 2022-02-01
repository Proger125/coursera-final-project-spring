package edu.epam.pet.service.impl;

import edu.epam.pet.converter.impl.ActorConverter;
import edu.epam.pet.dao.ActorDao;
import edu.epam.pet.dto.ActorDto;
import edu.epam.pet.entity.Actor;
import edu.epam.pet.exception.resource.ResourceNotFoundException;
import edu.epam.pet.service.ActorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorDao actorDao;
    private final ActorConverter actorConverter;

    public ActorServiceImpl(ActorDao actorDao, ActorConverter actorConverter) {
        this.actorDao = actorDao;
        this.actorConverter = actorConverter;
    }

    @Override
    public ActorDto save(ActorDto actorDto) {
        Actor actor = actorConverter.convertDtoToEntity(actorDto);
        return actorConverter.convertEntityToDto(actorDao.save(actor));
    }

    @Override
    public ActorDto findById(Long id) {
        Optional<Actor> actorOptional = actorDao.findById(id);
        if (actorOptional.isEmpty()) {
            throw new ResourceNotFoundException("Actor not found by id: " + id, id);
        }
        return actorConverter.convertEntityToDto(actorOptional.get());
    }

    @Override
    public Page<ActorDto> findAll(Pageable pageable) {
        return new PageImpl<>(
                actorDao.findAll(pageable)
                        .stream().map(actorConverter::convertEntityToDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public void deleteById(Long id) {
        Optional<Actor> optionalActor = actorDao.findById(id);
        if (optionalActor.isEmpty()) {
            throw new ResourceNotFoundException("Actor not found by id: " + id, id);
        }
        actorDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        actorDao.deleteAll();
    }
}
