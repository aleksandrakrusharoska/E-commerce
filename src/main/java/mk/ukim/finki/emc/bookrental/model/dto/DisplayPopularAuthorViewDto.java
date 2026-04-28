package mk.ukim.finki.emc.bookrental.model.dto;

import mk.ukim.finki.emc.bookrental.model.views.PopularAuthorView;

public record DisplayPopularAuthorViewDto(
        Long authorId,
        String authorFullName,
        Long totalRentals
) {
    public static DisplayPopularAuthorViewDto from(PopularAuthorView view) {
        return new DisplayPopularAuthorViewDto(
                view.getAuthorId(),
                view.getAuthorFullName(),
                view.getTotalRentals()
        );
    }
}