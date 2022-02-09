package edu.epam.pet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActorDto extends Dto{

    @Pattern(regexp = "[A-Z][a-z]{1,10}")
    private String firstName;

    @Pattern(regexp = "[A-Z][a-z]{1,12}")
    private String lastName;

    @NotNull
    private LocalDateTime birthDate;

    @NotNull
    private String gender;
}
