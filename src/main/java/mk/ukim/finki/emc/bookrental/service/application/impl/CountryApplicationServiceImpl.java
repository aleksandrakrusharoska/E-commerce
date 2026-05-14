package mk.ukim.finki.emc.bookrental.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.Country;
import mk.ukim.finki.emc.bookrental.model.dto.CountryDto;
import mk.ukim.finki.emc.bookrental.model.dto.CreateCountryDto;
import mk.ukim.finki.emc.bookrental.service.application.CountryApplicationService;
import mk.ukim.finki.emc.bookrental.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    private CountryDto toDto(Country c) {
        return new CountryDto(c.getId(), c.getName(), c.getContinent());
    }

    @Override
    public List<CountryDto> findAll() {
        return countryService.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<CountryDto> findById(Long id) {
        return countryService.findById(id).map(this::toDto);
    }

    @Override
    public CountryDto create(CreateCountryDto dto) {
        return toDto(countryService.create(new Country(dto.name(), dto.continent())));
    }

    @Override
    public Optional<CountryDto> update(Long id, CreateCountryDto dto) {
        return countryService.update(id, new Country(dto.name(), dto.continent())).map(this::toDto);
    }

    @Override
    public Optional<CountryDto> deleteById(Long id) {
        return countryService.deleteById(id).map(this::toDto);
    }
}