package com.oburnett127.socialmedia.service;

import com.oburnett127.socialmedia.config.ApplicationConfig;
import com.oburnett127.socialmedia.model.Role;
import com.oburnett127.socialmedia.model.Token;
import com.oburnett127.socialmedia.model.TokenType;
import com.oburnett127.socialmedia.model.User;
import com.oburnett127.socialmedia.model.request.AuthenticationRequest;
import com.oburnett127.socialmedia.model.request.RegisterRequest;
import com.oburnett127.socialmedia.model.response.AuthenticationResponse;
import com.oburnett127.socialmedia.repository.TokenRepository;
import com.oburnett127.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.bson.types.ObjectId;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ApplicationConfig applicationConfig;

    @SneakyThrows
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.USER)
                .build();

        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(applicationConfig.toUserDetails(savedUser));
        saveUserToken(savedUser, jwtToken.toString());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @SneakyThrows
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(applicationConfig.toUserDetails(user));
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken.toString());
        return AuthenticationResponse.builder()
                .token(jwtToken.toString())
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUserId(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @SneakyThrows
    public Role getRoleByUserId(ObjectId userId) {
        Optional<User> user = userRepository.findById(userId);
        User account = user.get();
        return account.getRole();
    }

    @SneakyThrows
    public ObjectId getUserIdByEmail(String emailAddress) {
        Optional<User> user = userRepository.findByEmail(emailAddress);
        return user.map(User::getId).get();
    }

    @SneakyThrows
    public Optional<User> getUserByEmail(String emailAddress) {
        return userRepository.findByEmail(emailAddress);
    }

    @SneakyThrows
    public List<User> getUserByName(String name) {
        String[] nameParts = name.split(" ");

        if (nameParts.length == 2) {
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            return userRepository.findByFirstNameAndLastName(firstName, lastName);
        } else if (nameParts.length == 1) {
            String providedName = nameParts[0];
            List<User> matchingUsers = userRepository.findByFirstName(providedName);
            matchingUsers.addAll(userRepository.findByLastName(providedName));
            return matchingUsers;
        }

        return null;
    }

    @SneakyThrows
    public List<User> getUsers(List<ObjectId> userIds) {
        return userIds.stream()
                .map(userId -> userRepository.findById(userId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public Optional<User> getUserByUserId(ObjectId userId) {
        return userRepository.findById(userId);
    }
}
