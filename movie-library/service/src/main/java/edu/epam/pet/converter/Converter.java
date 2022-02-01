package edu.epam.pet.converter;

/**
 * Converter interface used to convert dtos to entities and back.
 *
 * @param <Entity> the type parameter
 * @param <Dto>    the type parameter
 */
public interface Converter<Entity, Dto> {


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
