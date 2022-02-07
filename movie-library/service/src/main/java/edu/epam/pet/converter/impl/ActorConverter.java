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
    public Actor convertDtoToEntity(ActorRequestDto actorDto) {
        Actor actor = new Actor();
        actor.setFirstName(actorDto.getFirstName());
        actor.setLastName(actorDto.getLastName());
        actor.setBirthDate(actorDto.getBirthDate());
        try {
            actor.setGender(Gender.valueOf(actorDto.getGender().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalEnumArgumentException("Incorrect enum value: " + actorDto.getGender(), actorDto.getGender());
        }

        return actor;
    }

    @Override
    public ActorResponseDto convertEntityToDto(Actor actor) {
        ActorResponseDto actorDto = new ActorResponseDto();
        actorDto.setId(actor.getId());
        actorDto.setFirstName(actor.getFirstName());
        actorDto.setLastName(actor.getLastName());
        actorDto.setBirthDate(actor.getBirthDate());
        actorDto.setGender(actor.getGender().name());
        return actorDto;
    }
}
