package mk.ukim.finki.emc.bookrental.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.Author;
import mk.ukim.finki.emc.bookrental.model.domain.Country;
import mk.ukim.finki.emc.bookrental.model.dto.AuthorDto;
import mk.ukim.finki.emc.bookrental.model.dto.CountryDto;
import mk.ukim.finki.emc.bookrental.model.dto.CreateAuthorDto;
import mk.ukim.finki.emc.bookrental.service.application.AuthorApplicationService;
import mk.ukim.finki.emc.bookrental.service.domain.AuthorService;
import mk.ukim.finki.emc.bookrental.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorApplicationServiceImpl implements AuthorApplicationService {

    private final AuthorService authorService;
    private final CountryService countryService;

    private AuthorDto toDto(Author a) {
        CountryDto countryDto = a.getCountry() != null
                ? new CountryDto(a.getCountry().getId(), a.getCountry().getName(), a.getCountry().getContinent())
                : null;
        return new AuthorDto(a.getId(), a.getName(), a.getSurname(), countryDto);
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorService.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<AuthorDto> findById(Long id) {
        return authorService.findByIdWithCountry(id).map(this::toDto);
    }

    @Override
    public AuthorDto create(CreateAuthorDto dto) {
        Country country = countryService.findById(dto.countryId())
                .orElseThrow(() -> new RuntimeException("Country not found: " + dto.countryId()));
        Author author = new Author();
        author.setName(dto.name());
        author.setSurname(dto.surname());
        author.setCountry(country);
        return toDto(authorService.create(author));
    }

    @Override
    public Optional<AuthorDto> update(Long id, CreateAuthorDto dto) {
        Country country = countryService.findById(dto.countryId())
                .orElseThrow(() -> new RuntimeException("Country not found: " + dto.countryId()));
        Author updated = new Author();
        updated.setName(dto.name());
        updated.setSurname(dto.surname());
        updated.setCountry(country);
        return authorService.update(id, updated).map(this::toDto);
    }

    @Override
    public Optional<AuthorDto> deleteById(Long id) {
        return authorService.deleteById(id).map(this::toDto);
    }
}