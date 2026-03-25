//package mk.ukim.finki.emc.bookrental.web.controller;
//
//import lombok.RequiredArgsConstructor;
//import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookStatisticsDto;
//import mk.ukim.finki.emc.bookrental.service.application.BookStatisticsViewApplicationService;
//import mk.ukim.finki.emc.bookrental.service.domain.MaterializedViewRefreshService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/book-statistics")
//@RequiredArgsConstructor
//public class BookStatisticsViewController {
//
//    private final BookStatisticsViewApplicationService service;
//    private final MaterializedViewRefreshService refreshService;
//
//    @GetMapping
//    public ResponseEntity<List<DisplayBookStatisticsDto>> findAll() {
//        return ResponseEntity.ok(service.findAll());
//    }
//
//    @PostMapping("/refresh")
//    public ResponseEntity<Void> refresh() {
//        refreshService.refreshBookStatistics();
//        return ResponseEntity.ok().build();
//    }
//}