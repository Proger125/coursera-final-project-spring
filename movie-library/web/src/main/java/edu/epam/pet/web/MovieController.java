package edu.epam.pet.web;

import edu.epam.pet.dto.movie.MovieRequestDto;
import edu.epam.pet.dto.movie.MovieResponseDto;
import edu.epam.pet.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/movies")
@RestController
public class MovieController implements CrudController<MovieRequestDto, MovieResponseDto>{

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto save(@RequestBody MovieRequestDto dto) {
        return movieService.save(dto);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieResponseDto findById(@PathVariable Long id) {
        return movieService.findById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieResponseDto> findAll(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "5", required = false) int size
    ) {
        return movieService.findAll(PageRequest.of(page, size));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }

    @Override
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        movieService.deleteAll();
    }
}
