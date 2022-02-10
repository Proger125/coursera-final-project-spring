package edu.epam.pet.converter;

import edu.epam.pet.dto.Dto;
import edu.epam.pet.entity.BaseEntity;

/**
 * Converter interface used to convert dtos to entities and back.
 *
 * @param <Entity> - model of current entity
 * @param <RequestDto>> - input dto model of current entity
 * @param <ResponseDto> - output dto model of current entity
 */
public interface Converter<Entity extends BaseEntity, RequestDto extends edu.epam.pet.dto.Dto, ResponseDto extends Dto> {


    /**
     * Converts dto to entity.
     *
     * @param dto - dto
     * @return entity
     */
    Entity convertDtoToEntity(RequestDto dto);

    /**
     * Converts entity to dto
     * @param entity - entity
     * @return dto
     */
    ResponseDto convertEntityToDto(Entity entity);
}
