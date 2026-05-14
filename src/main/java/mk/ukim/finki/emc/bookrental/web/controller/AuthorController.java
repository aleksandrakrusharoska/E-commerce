package mk.ukim.finki.emc.bookrental.web.controller;

import mk.ukim.finki.emc.bookrental.model.dto.AuthorDto;
import mk.ukim.finki.emc.bookrental.model.dto.CreateAuthorDto;
import mk.ukim.finki.emc.bookrental.service.application.AuthorApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorApplicationService authorApplicationService;

    public AuthorController(AuthorApplicationService authorApplicationService) {
        this.authorApplicationService = authorApplicationService;
    }

    @GetMapping
    public List<AuthorDto> findAll() {
        return authorApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> findById(@PathVariable Long id) {
        return authorApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<AuthorDto> create(@RequestBody CreateAuthorDto dto) {
        return ResponseEntity.ok(authorApplicationService.create(dto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<AuthorDto> update(@PathVariable Long id, @RequestBody CreateAuthorDto dto) {
        return authorApplicationService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<AuthorDto> deleteById(@PathVariable Long id) {
        return authorApplicationService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}