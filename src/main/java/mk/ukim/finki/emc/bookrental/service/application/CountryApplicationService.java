package mk.ukim.finki.emc.bookrental.service.application;

import mk.ukim.finki.emc.bookrental.model.dto.CountryDto;
import mk.ukim.finki.emc.bookrental.model.dto.CreateCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<CountryDto> findAll();
    Optional<CountryDto> findById(Long id);
    CountryDto create(CreateCountryDto dto);
    Optional<CountryDto> update(Long id, CreateCountryDto dto);
    Optional<CountryDto> deleteById(Long id);
}