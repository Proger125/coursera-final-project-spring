package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.actor.ActorRequestDto;
import edu.epam.pet.dto.actor.ActorResponseDto;
import edu.epam.pet.entity.Actor;
import edu.epam.pet.entity.Gender;
import edu.epam.pet.exception.converter.IllegalEnumArgumentException;
import org.springframework.stereotype.Component;

@Component
public class ActorConverter implements Converter<Actor, ActorRequestDto, ActorResponseDto> {
    @Override
    public Actor convertDtoToEntity(ActorRequestDto dto) {
        Actor actor = new Actor();
        actor.setId(dto.getId());
        actor.setFirstName(dto.getFirstName());
        actor.setLastName(dto.getLastName());
        actor.setBirthDate(dto.getBirthDate());
        try{
            actor.setGender(Gender.valueOf(dto.getGender().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalEnumArgumentException("Incorrect enum value: " + dto.getGender(), dto.getGender());
        }
        return actor;
    }

    @Override
    public ActorResponseDto convertEntityToDto(Actor entity) {
        ActorResponseDto actorResponseDto = new ActorResponseDto();
        actorResponseDto.setId(entity.getId());
        actorResponseDto.setFirstName(entity.getFirstName());
        actorResponseDto.setLastName(entity.getLastName());
        actorResponseDto.setBirthDate(entity.getBirthDate());
        actorResponseDto.setGender(entity.getGender().name());
        return actorResponseDto;
    }
}
