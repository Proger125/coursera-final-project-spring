package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.EntityToDtoConverter;
import edu.epam.pet.dto.place.PlaceResponseDto;
import edu.epam.pet.entity.Place;
import org.springframework.stereotype.Component;

@Component
public class PlaceConverter implements EntityToDtoConverter<Place, PlaceResponseDto> {

    @Override
    public PlaceResponseDto convertEntityToDto(Place entity) {
        return null;
    }
}
