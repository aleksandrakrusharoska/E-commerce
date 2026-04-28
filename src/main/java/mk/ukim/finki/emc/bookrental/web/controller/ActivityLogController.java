package mk.ukim.finki.emc.bookrental.web.controller;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.ActivityLog;
import mk.ukim.finki.emc.bookrental.service.domain.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @GetMapping
    public Page<ActivityLog> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "eventTime") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        List<String> allowedSortFields = List.of("id", "bookName", "eventTime", "eventType");

        if (!allowedSortFields.contains(sortBy)) {
            sortBy = "eventTime";
        }

        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return activityLogService.findAll(pageable);
    }
}