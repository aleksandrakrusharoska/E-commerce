package mk.ukim.finki.emc.bookrental.model.dto;

import mk.ukim.finki.emc.bookrental.model.views.BookStatisticsView;

public record DisplayBookStatisticsDto(
        String category,
        Long totalBooks,
        Integer totalAvailableCopies,
        Long booksNotInGoodCondition
) {
    public static DisplayBookStatisticsDto from(BookStatisticsView view) {
        return new DisplayBookStatisticsDto(
                view.getCategory(),
                view.getTotalBooks(),
                view.getTotalAvailableCopies(),
                view.getBooksNotInGoodCondition()
        );
    }
}