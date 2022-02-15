package edu.epam.pet.dao;

import edu.epam.pet.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDao extends JpaRepository<Place, Long> {
}
