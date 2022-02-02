package edu.epam.pet.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "actors")
public class Actor extends BaseEntity {

    private String firstName;

    private String lastName;

    private LocalDateTime birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
