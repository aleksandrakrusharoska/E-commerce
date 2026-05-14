package mk.ukim.finki.emc.bookrental.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Role;
import mk.ukim.finki.emc.bookrental.model.domain.User;
import mk.ukim.finki.emc.bookrental.model.dto.LoginRequest;
import mk.ukim.finki.emc.bookrental.model.dto.LoginResponse;
import mk.ukim.finki.emc.bookrental.model.dto.RegisterRequest;
import mk.ukim.finki.emc.bookrental.model.exception.UsernameAlreadyExistsException;
import mk.ukim.finki.emc.bookrental.repository.UserRepository;
import mk.ukim.finki.emc.bookrental.service.domain.impl.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginResponse register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new RuntimeException("Passwords do not match");
        }
        if (userRepository.existsById(request.getUsername())) {
            throw new UsernameAlreadyExistsException(request.getUsername());
        }

        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getName(),
                request.getSurname(),
                Role.ROLE_USER
        );
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return new LoginResponse(jwtToken);
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String jwtToken = jwtService.generateToken(user);
        return new LoginResponse(jwtToken);
    }
}