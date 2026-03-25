package mk.ukim.finki.emc.bookrental.web.controller;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.ActivityLog;
import mk.ukim.finki.emc.bookrental.service.domain.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @GetMapping
    public Page<ActivityLog> findAll(Pageable pageable) {
        return activityLogService.findAll(pageable);
    }
}