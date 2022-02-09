package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.ActorDto;
import edu.epam.pet.entity.Actor;
import edu.epam.pet.entity.Gender;
import edu.epam.pet.exception.converter.IllegalEnumArgumentException;
import org.springframework.stereotype.Component;

@Component
public class ActorConverter implements Converter<Actor, ActorDto> {
    @Override
    public Actor convertDtoToEntity(ActorDto dto) {
        Actor actor = new Actor();
        actor.setId(dto.getId());
        actor.setFirstName(dto.getFirstName());
        actor.setLastName(dto.getLastName());
        actor.setBirthDate(dto.getBirthDate());
        try{
            actor.setGender(Gender.valueOf(dto.getGender()));
        } catch (IllegalArgumentException e) {
            throw new IllegalEnumArgumentException("Incorrect enum value: " + dto.getGender(), dto.getGender());
        }
        return actor;
    }

    @Override
    public ActorDto convertEntityToDto(Actor entity) {
        ActorDto actorDto = new ActorDto();
        actorDto.setId(entity.getId());
        actorDto.setFirstName(entity.getFirstName());
        actorDto.setLastName(entity.getLastName());
        actorDto.setBirthDate(entity.getBirthDate());
        actorDto.setGender(entity.getGender().name());
        return actorDto;
    }
}
