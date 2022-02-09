package edu.epam.pet.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public abstract class Dto {

    @Min(1)
    private Long id;
}
