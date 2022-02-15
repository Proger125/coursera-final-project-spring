package edu.epam.pet.web;

import edu.epam.pet.dto.ticket.TicketRequestDto;
import edu.epam.pet.dto.ticket.TicketResponseDto;
import edu.epam.pet.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController implements CrudController<TicketRequestDto, TicketResponseDto>{

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponseDto save(@RequestBody TicketRequestDto ticketRequestDto) {
        return ticketService.save(ticketRequestDto);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketResponseDto findById(@PathVariable Long id) {
        return ticketService.findById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TicketResponseDto> findAll(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "3", required = false) int size
    ) {
        return ticketService.findAll(PageRequest.of(page, size));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        ticketService.deleteById(id);
    }

    @Override
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        ticketService.deleteAll();
    }
}
