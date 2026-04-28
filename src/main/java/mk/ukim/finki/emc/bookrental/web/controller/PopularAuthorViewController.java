package mk.ukim.finki.emc.bookrental.web.controller;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayPopularAuthorViewDto;
import mk.ukim.finki.emc.bookrental.model.views.PopularAuthorView;
import mk.ukim.finki.emc.bookrental.service.domain.PopularAuthorViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/popular-authors-view")
@RequiredArgsConstructor
public class PopularAuthorViewController {

    private final PopularAuthorViewService service;

    @GetMapping
    public ResponseEntity<List<PopularAuthorView>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}