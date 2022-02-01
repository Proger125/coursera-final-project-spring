package edu.epam.pet.dao;

import edu.epam.pet.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorDao extends JpaRepository<Actor, Long> {
}
