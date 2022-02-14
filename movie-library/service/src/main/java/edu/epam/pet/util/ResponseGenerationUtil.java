package edu.epam.pet.util;

import edu.epam.pet.entity.*;
import org.springframework.stereotype.Component;

@Component
public class ResponseGenerationUtil {

    public String createActorStringResponse(Actor actor) {
        return  "Id: " + actor.getId() + ", " +
                "First name: " + actor.getFirstName() + ", " +
                "Last name: " + actor.getLastName() + ", " +
                "Birth date: " + actor.getBirthDate() + ", " +
                "Gender: " + actor.getGender() + ".";
    }

    public String createMovieStringResponse(Movie movie) {
        return "Id: " + movie.getId() + ", " +
                "Name: " + movie.getName() + ", " +
                "Duration: " + movie.getDuration() + ", " +
                "Profit: " + movie.getProfit() + ", " +
                "Creation year: " + movie.getCreationYear() + ", " +
                "Genre: " + movie.getGenre() + ".";
    }

    public String createCinemaHallStringResponse(CinemaHall cinemaHall) {
        return "Id: " + cinemaHall.getId() + ", " +
                "Cost of one place: " + cinemaHall.getOnePlaceCost() + ", " +
                "Cinema: " + createCinemaStringResponse(cinemaHall.getCinema()) + ".";
    }

    public String createCinemaStringResponse(Cinema cinema) {
        return "Id: " + cinema.getId() + ", " +
                "Name: " + cinema.getName() + ".";
    }

    public String createCinemaSessionStringResponse(CinemaSession cinemaSession) {
        return "Id: " + cinemaSession.getId() + ", " +
                "Movie: " + createMovieStringResponse(cinemaSession.getMovie()) + ", " +
                "Cinema hall: " + createCinemaHallStringResponse(cinemaSession.getCinemaHall()) + ".";
    }

    public String createPlaceStringResponse(Place place) {
        return "Id: " + place.getId() + ", " +
                "Place: " + place.getSeatPlace() + ", " +
                "Row: " + place.getSeatRow() + ", " +
                "Cinema session: " + createCinemaSessionStringResponse(place.getCinemaSession()) + ".";
    }
}
