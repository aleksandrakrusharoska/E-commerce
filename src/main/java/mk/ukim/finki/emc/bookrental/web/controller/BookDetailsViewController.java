package mk.ukim.finki.emc.bookrental.web.controller;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDetailsViewDto;
import mk.ukim.finki.emc.bookrental.service.application.BookDetailsViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book-details-view")
@RequiredArgsConstructor
public class BookDetailsViewController {

    private final BookDetailsViewApplicationService service;

    @GetMapping
    public ResponseEntity<List<DisplayBookDetailsViewDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}