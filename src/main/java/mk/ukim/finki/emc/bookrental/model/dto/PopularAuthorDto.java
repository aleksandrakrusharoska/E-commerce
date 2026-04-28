package mk.ukim.finki.emc.bookrental.model.dto;

public record PopularAuthorDto(
        Long authorId,
        String authorFullName,
        Long totalRentals
) {
}
