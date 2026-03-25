package mk.ukim.finki.emc.bookrental.model.dto;

import mk.ukim.finki.emc.bookrental.model.views.BookDetailsView;

public record DisplayBookDetailsViewDto(
        Long id,
        String name,
        String category,
        String state,
        Integer availableCopies,
        String authorFullName,
        String countryName
) {
    public static DisplayBookDetailsViewDto from(BookDetailsView view) {
        return new DisplayBookDetailsViewDto(
                view.getId(),
                view.getName(),
                view.getCategory(),
                view.getState(),
                view.getAvailableCopies(),
                view.getAuthorFullName(),
                view.getCountryName()
        );
    }
}