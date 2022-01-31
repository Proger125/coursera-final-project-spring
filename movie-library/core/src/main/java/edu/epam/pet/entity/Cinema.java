package edu.epam.pet.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "cinemas")
public class Cinema extends BaseEntity {

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "cinema_movie",
            joinColumns = {@JoinColumn(name = "cinema_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")}
    )
    @ToString.Exclude
    private Set<Movie> movies;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<CinemaHall> halls;

}
