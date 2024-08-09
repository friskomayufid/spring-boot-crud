package friskodev.restapispring.service;

import friskodev.restapispring.entity.User;
import friskodev.restapispring.model.LoginUserRequest;
import friskodev.restapispring.model.TokenResponse;
import friskodev.restapispring.repository.UserRepository;
import friskodev.restapispring.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    public TokenResponse login(LoginUserRequest request) {
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username / Password Wrong"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());

            return TokenResponse
                    .builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username / Password Wrong");
        }

    }

    private Long next30Days () {
        return System.currentTimeMillis() + (1000 * 60 * 24 * 30);
    }
}
