package edu.epam.pet.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@javax.persistence.Entity
public class Actor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDate;

    private Gender gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Actor actor = (Actor) o;
        return getId() != null && Objects.equals(getId(), actor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
