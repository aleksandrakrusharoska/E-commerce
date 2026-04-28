package mk.ukim.finki.emc.bookrental.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;
import mk.ukim.finki.emc.bookrental.model.dto.CreateBookDto;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDetailsDto;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDto;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookSearchDto;
import mk.ukim.finki.emc.bookrental.model.projection.BookExpandedProjection;
import mk.ukim.finki.emc.bookrental.model.projection.BookShortProjection;
import mk.ukim.finki.emc.bookrental.service.application.BookApplicationService;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<DisplayBookDetailsDto> findById(@PathVariable Long id) {
        return bookApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
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

    @GetMapping
    public ResponseEntity<Page<DisplayBookSearchDto>> search(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) State state,
            @RequestParam(required = false) Long authorId,
            @RequestParam(required = false) Boolean hasAvailableCopies
    ) {
        return ResponseEntity.ok(
                bookApplicationService.search(
                        page, size, sortBy, direction,
                        category, state, authorId, hasAvailableCopies
                )
        );
    }

    @GetMapping("/short")
    public ResponseEntity<Page<BookShortProjection>> findAllShort(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return ResponseEntity.ok(
                bookApplicationService.findAllShort(page, size, sortBy, direction)
        );
    }

    @GetMapping("/expanded")
    public ResponseEntity<Page<BookExpandedProjection>> findAllExpanded(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return ResponseEntity.ok(
                bookApplicationService.findAllExpanded(page, size, sortBy, direction)
        );
    }

    @GetMapping("/popular")
    public ResponseEntity<List<DisplayBookDto>> findTopPopularBooks() {
        return ResponseEntity.ok(bookApplicationService.findTopPopularBooks());
    }
}