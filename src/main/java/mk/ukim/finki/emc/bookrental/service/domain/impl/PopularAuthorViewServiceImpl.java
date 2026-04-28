package mk.ukim.finki.emc.bookrental.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayPopularAuthorViewDto;
import mk.ukim.finki.emc.bookrental.model.views.PopularAuthorView;
import mk.ukim.finki.emc.bookrental.repository.PopularAuthorViewRepository;
import mk.ukim.finki.emc.bookrental.service.domain.PopularAuthorViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularAuthorViewServiceImpl implements PopularAuthorViewService {

    private final PopularAuthorViewRepository repository;

    @Override
    public List<PopularAuthorView> findAll() {
        return repository.findAll();
    }
}
