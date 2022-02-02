package edu.epam.pet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActorDto extends Dto {

    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]{1,10}$")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]{1,15}$")
    private String lastName;

    @NotNull
    private LocalDateTime birthDate;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]{4,6}$")
    private String gender;
}
