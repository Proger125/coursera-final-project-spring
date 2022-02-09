package edu.epam.pet.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public abstract class Dto {

    @Min(value = 0)
    private Long id;
}
