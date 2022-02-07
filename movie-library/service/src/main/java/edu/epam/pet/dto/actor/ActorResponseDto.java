package edu.epam.pet.dto.actor;

import edu.epam.pet.dto.ResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActorResponseDto extends ResponseDto {

    private String firstName;

    private String lastName;

    private LocalDateTime birthDate;

    private String gender;
}
