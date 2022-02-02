package edu.epam.pet.web;

import org.springframework.data.domain.Page;

/**
 * Interface which provides CRUD functionality to Controller objects
 * @param <Dto> - type of dto instance
 */

public interface CrudController<Dto extends edu.epam.pet.dto.Dto> {

    /**
     * Saves entity to database
     * @param dto - dto instance of entity
     * @return dto instance of saved entity
     */
    Dto save(Dto dto);

    /**
     * Finds entity by id
     * @param id - entity's id
     * @return - dto instance of queried entity
     */
    Dto findById(Long id);

    /**
     * Finds all entities according to the pagination parameters
     * @param page - number of page
     * @param size - page size
     * @return - dto instances of queried entities according to parameters
     */
    Page<Dto> findAll(int page, int size);

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
