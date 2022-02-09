package edu.epam.pet.converter;

import edu.epam.pet.dto.Dto;
import edu.epam.pet.entity.BaseEntity;

/**
 * Converter interface used to convert dtos to entities and back.
 *
 * @param <Entity> - model of current entity
 * @param <Dto> - input dto model of current entity
 */
public interface Converter<Entity extends BaseEntity, Dto extends edu.epam.pet.dto.Dto> {


    /**
     * Converts dto to entity.
     *
     * @param dto - dto
     * @return entity
     */
    Entity convertDtoToEntity(Dto dto);

    /**
     * Converts entity to dto
     * @param entity - entity
     * @return dto
     */
    Dto convertEntityToDto(Entity entity);
}
