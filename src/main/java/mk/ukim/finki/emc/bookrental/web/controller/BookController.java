package mk.ukim.finki.emc.bookrental.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.emc.bookrental.model.dto.CreateBookDto;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDto;
import mk.ukim.finki.emc.bookrental.service.application.BookApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookApplicationService bookApplicationService;

    public BookController(BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id) {
        return bookApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayBookDto>> findAll() {
        return ResponseEntity.ok(bookApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> create(@RequestBody @Valid CreateBookDto createBookDto) {
        return ResponseEntity.ok(bookApplicationService.create(createBookDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayBookDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateBookDto createBookDto
    ) {
        return bookApplicationService
                .update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayBookDto> deleteById(@PathVariable Long id) {
        return bookApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/rent")
    public ResponseEntity<DisplayBookDto> markAsRented(@PathVariable Long id) {
        return ResponseEntity.ok(bookApplicationService.markAsRented(id));
    }

    @GetMapping("/range")
    public ResponseEntity<List<DisplayBookDto>> findAllByIdIsBetween(@RequestParam Long a, @RequestParam Long b) {
        return ResponseEntity.ok(bookApplicationService.findAllByIdIsBetween(a, b));
    }

}