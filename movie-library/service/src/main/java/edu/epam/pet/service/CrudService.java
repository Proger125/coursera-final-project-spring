package edu.epam.pet.service;

import edu.epam.pet.dto.Dto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface which provides CRUD functionality to Service objects
 * @param <RequestDto> - input dto model of current entity
 * @param <ResponseDto> - output dto model of current entity
 */
public interface CrudService<RequestDto extends edu.epam.pet.dto.Dto, ResponseDto extends Dto> {

    /**
     * Saves entity to database
     * @param dto - dto instance of entity
     * @return dto instance of saved entity
     */
    ResponseDto save(RequestDto dto);

    /**
     * Finds entity by id
     * @param id - entity's id
     * @return - dto instance of queried entity
     */
    ResponseDto findById(Long id);

    /**
     * Finds all entities according to the pagination parameters
     * @param pageable - pagination parameters
     * @return - dto instances of queried entities
     */
    Page<ResponseDto> findAll(Pageable pageable);

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
