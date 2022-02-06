package edu.epam.pet.dao;

import edu.epam.pet.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ActorDao extends JpaRepository<Actor, Long> {
    Optional<Actor> findActorByFirstNameAndLastNameAndBirthDate(
            String firstName,
            String lastName,
            LocalDateTime birthDate);
}
