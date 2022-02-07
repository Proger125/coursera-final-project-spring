package edu.epam.pet.util;

import edu.epam.pet.entity.CinemaSession;
import edu.epam.pet.entity.Place;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PlaceGenerationUtil {

    public Set<Place> generateEmptyPlaces(int rowAmount, int seatsInRowAmount, CinemaSession cinemaSession) {
        Set<Place> places = new HashSet<>();
        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < seatsInRowAmount; j++) {
                Place place = new Place();
                place.setCinemaSession(cinemaSession);
                place.setSeatRow(i);
                place.setSeatPlace(j);
                place.setTaken(false);
                places.add(place);
            }
        }
        return places;
    }
}
