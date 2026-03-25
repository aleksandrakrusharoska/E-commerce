package mk.ukim.finki.emc.bookrental.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.emc.bookrental.model.domain.ActivityLog;
import mk.ukim.finki.emc.bookrental.events.BookRentedEvent;
import mk.ukim.finki.emc.bookrental.repository.ActivityLogRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookUnavailableEventListener {

    private final ActivityLogRepository activityLogRepository;

    @EventListener
    public void handleBookUnavailable(BookRentedEvent event) {
        if (event.book().getAvailableCopies() == 0) {
            String bookName = event.book().getName();

            log.warn("Book is now unavailable: {}", bookName);

            ActivityLog activityLog = new ActivityLog(
                    bookName,
                    LocalDateTime.now(),
                    "BOOK_UNAVAILABLE"
            );

            activityLogRepository.save(activityLog);
        }
    }
}