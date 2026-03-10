package mk.ukim.finki.emc.bookrental.repository;

import mk.ukim.finki.emc.bookrental.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
