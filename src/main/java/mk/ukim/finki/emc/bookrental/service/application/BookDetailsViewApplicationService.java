package mk.ukim.finki.emc.bookrental.service.application;

import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDetailsViewDto;

import java.util.List;

public interface BookDetailsViewApplicationService {
    List<DisplayBookDetailsViewDto> findAll();
}