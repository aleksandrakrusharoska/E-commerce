package mk.ukim.finki.emc.bookrental.repository;

import mk.ukim.finki.emc.bookrental.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a JOIN FETCH a.country")
    List<Author> findAllWithCountry();

    @Query("SELECT a FROM Author a JOIN FETCH a.country WHERE a.id = :id")
    Optional<Author> findByIdWithCountry(@Param("id") Long id);
}
