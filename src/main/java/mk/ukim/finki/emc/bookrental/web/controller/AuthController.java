package mk.ukim.finki.emc.bookrental.web.controller;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.dto.LoginRequest;
import mk.ukim.finki.emc.bookrental.model.dto.LoginResponse;
import mk.ukim.finki.emc.bookrental.model.dto.RegisterRequest;
import mk.ukim.finki.emc.bookrental.service.application.impl.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}