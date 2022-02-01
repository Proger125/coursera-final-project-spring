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
    public Actor convertDtoToEntity(ActorDto actorDto) {
        Actor actor = new Actor();
        actor.setId(actorDto.getId());
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
    public ActorDto convertEntityToDto(Actor actor) {
        ActorDto actorDto = new ActorDto();
        actorDto.setId(actor.getId());
        actorDto.setFirstName(actor.getFirstName());
        actorDto.setLastName(actor.getLastName());
        actorDto.setBirthDate(actor.getBirthDate());
        actorDto.setGender(actor.getGender().name());
        return actorDto;
    }
}
