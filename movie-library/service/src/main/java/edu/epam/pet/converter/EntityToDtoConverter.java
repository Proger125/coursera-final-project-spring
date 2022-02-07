package edu.epam.pet.converter;

import edu.epam.pet.entity.BaseEntity;

public interface EntityToDtoConverter<Entity extends BaseEntity, ResponseDto extends edu.epam.pet.dto.ResponseDto> {

    ResponseDto convertEntityToDto(Entity entity);
}
