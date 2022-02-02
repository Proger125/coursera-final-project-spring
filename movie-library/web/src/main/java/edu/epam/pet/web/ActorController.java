package edu.epam.pet.web;

import edu.epam.pet.dto.ActorDto;
import edu.epam.pet.service.ActorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorController implements CrudController<ActorDto>{

    private final ActorService service;

    public ActorController(ActorService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActorDto save(@RequestBody ActorDto actorDto) {
        return service.save(actorDto);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActorDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ActorDto> findAll(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                  @RequestParam(name = "size", defaultValue = "5", required = false) int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @Override
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        service.deleteAll();
    }
}
