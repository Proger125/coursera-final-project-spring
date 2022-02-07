package edu.epam.pet.dto.cinema;

import edu.epam.pet.dto.RequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaRequestDto extends RequestDto {

    private String name;
}
