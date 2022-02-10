package edu.epam.pet.dao;

import edu.epam.pet.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaDao extends JpaRepository<Cinema, Long> {
}
