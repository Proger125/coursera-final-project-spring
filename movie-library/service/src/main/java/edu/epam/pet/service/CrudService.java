package edu.epam.pet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<Dto> {

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
     * @param pageable - pagination parameters
     * @return - dto instances of queried entities
     */
    Page<Dto> findAll(Pageable pageable);

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
