package edu.epam.pet.web;

import edu.epam.pet.dto.cinemasession.CinemaSessionRequestDto;
import edu.epam.pet.dto.cinemasession.CinemaSessionResponseDto;
import edu.epam.pet.service.CinemaSessionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinema-sessions")
public class CinemaSessionController implements CrudController<CinemaSessionRequestDto, CinemaSessionResponseDto> {

    private final CinemaSessionService cinemaSessionService;

    public CinemaSessionController(CinemaSessionService cinemaSessionService) {
        this.cinemaSessionService = cinemaSessionService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaSessionResponseDto save(@RequestBody CinemaSessionRequestDto cinemaSessionRequestDto) {
        return cinemaSessionService.save(cinemaSessionRequestDto);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CinemaSessionResponseDto findById(@PathVariable Long id) {
        return cinemaSessionService.findById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CinemaSessionResponseDto> findAll(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "3", required = false) int size
    ) {
        return cinemaSessionService.findAll(PageRequest.of(page, size));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        cinemaSessionService.deleteById(id);
    }

    @Override
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        cinemaSessionService.deleteAll();
    }
}
