package mk.ukim.finki.emc.bookrental.model.dto;

public record AuthorDto(
        Long id,
        String name,
        String surname,
        CountryDto country
) {}
