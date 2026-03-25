package mk.ukim.finki.emc.bookrental.service.domain;

import mk.ukim.finki.emc.bookrental.model.domain.ActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActivityLogService {
    Page<ActivityLog> findAll(Pageable pageable);
}