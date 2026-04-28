package mk.ukim.finki.emc.bookrental.service.domain;

import mk.ukim.finki.emc.bookrental.model.dto.DisplayPopularAuthorViewDto;
import mk.ukim.finki.emc.bookrental.model.views.PopularAuthorView;

import java.util.List;

public interface PopularAuthorViewService {
    List<PopularAuthorView> findAll();
}
