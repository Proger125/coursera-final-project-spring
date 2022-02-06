package edu.epam.pet.dao;

import edu.epam.pet.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Long> {
}
