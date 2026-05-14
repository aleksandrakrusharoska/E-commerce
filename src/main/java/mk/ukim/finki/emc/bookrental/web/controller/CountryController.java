package mk.ukim.finki.emc.bookrental.web.controller;

import mk.ukim.finki.emc.bookrental.model.dto.CountryDto;
import mk.ukim.finki.emc.bookrental.model.dto.CreateCountryDto;
import mk.ukim.finki.emc.bookrental.service.application.CountryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping
    public List<CountryDto> findAll() {
        return countryApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> findById(@PathVariable Long id) {
        return countryApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<CountryDto> create(@RequestBody CreateCountryDto dto) {
        return ResponseEntity.ok(countryApplicationService.create(dto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<CountryDto> update(@PathVariable Long id, @RequestBody CreateCountryDto dto) {
        return countryApplicationService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<CountryDto> deleteById(@PathVariable Long id) {
        return countryApplicationService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}