package edu.epam.pet.dao;

import edu.epam.pet.entity.CinemaSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaSessionDao extends JpaRepository<CinemaSession, Long> {
}
