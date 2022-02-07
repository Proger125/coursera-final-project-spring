package edu.epam.pet.dao;

import edu.epam.pet.entity.CinemaSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaSessionDao extends JpaRepository<CinemaSession, Long> {
}
