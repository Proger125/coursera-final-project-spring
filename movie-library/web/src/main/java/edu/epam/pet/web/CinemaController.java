package edu.epam.pet.web;

import edu.epam.pet.dto.cinema.CinemaRequestDto;
import edu.epam.pet.dto.cinema.CinemaResponseDto;
import edu.epam.pet.service.CinemaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinemas")
public class CinemaController implements CrudController<CinemaRequestDto, CinemaResponseDto>{

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaResponseDto save(@RequestBody CinemaRequestDto cinemaRequestDto) {
        return cinemaService.save(cinemaRequestDto);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CinemaResponseDto findById(@PathVariable Long id) {
        return cinemaService.findById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CinemaResponseDto> findAll(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "3", required = false) int size
    ) {
        return cinemaService.findAll(PageRequest.of(page, size));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        cinemaService.deleteById(id);
    }

    @Override
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        cinemaService.deleteAll();
    }
}
