package edu.epam.pet.web;

import edu.epam.pet.dto.Dto;
import org.springframework.data.domain.Page;

/**
 * Interface which provides CRUD functionality to Controller objects
 * @param <RequestDto>> - input dto model of current entity
 */

public interface CrudController<RequestDto extends edu.epam.pet.dto.Dto, ResponseDto extends Dto> {

    /**
     * Saves entity to database
     * @param requestDto - dto instance of entity
     * @return dto instance of saved entity
     */
    ResponseDto save(RequestDto requestDto);

    /**
     * Finds entity by id
     * @param id - entity's id
     * @return - dto instance of queried entity
     */
    ResponseDto findById(Long id);

    /**
     * Finds all entities according to the pagination parameters
     * @param page - number of page
     * @param size - page size
     * @return - dto instances of queried entities according to parameters
     */
    Page<ResponseDto> findAll(int page, int size);

    /**
     * Deletes entity by id
     * @param id - entity's id
     */
    void deleteById(Long id);

    /**
     * Deletes all entities
     */
    void deleteAll();
}
