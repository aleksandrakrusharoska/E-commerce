package mk.ukim.finki.emc.bookrental.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.Country;
import mk.ukim.finki.emc.bookrental.repository.CountryRepository;
import mk.ukim.finki.emc.bookrental.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> update(Long id, Country updated) {
        return findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setContinent(updated.getContinent());
            return countryRepository.save(existing);
        });
    }

    @Override
    public Optional<Country> deleteById(Long id) {
        return findById(id).map(country -> {
            countryRepository.delete(country);
            return country;
        });
    }
}