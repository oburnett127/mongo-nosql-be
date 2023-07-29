package com.oburnett127.socialmedia.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.bson.types.ObjectId;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.oburnett127.socialmedia.model.Role;
import com.oburnett127.socialmedia.model.Token;
import com.oburnett127.socialmedia.model.TokenType;
import com.oburnett127.socialmedia.model.User;
import com.oburnett127.socialmedia.model.request.AuthenticationRequest;
import com.oburnett127.socialmedia.model.request.RegisterRequest;
import com.oburnett127.socialmedia.model.response.AuthenticationResponse;
import com.oburnett127.socialmedia.repository.TokenRepository;
import com.oburnett127.socialmedia.repository.UserRepository;
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
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(savedUser, jwtToken);

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
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  private void saveUserToken(User user, ObjectId jwtToken) {
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
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
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
  public ObjectId getUserIdByEmail(ObjectId emailAddress) {
    Optional<User> user = userRepository.findByEmail(emailAddress);
    ObjectId userId = user.get().getId();
    return userId;
  }

  @SneakyThrows
  public Optional<User> getUserByEmail(ObjectId emailAddress) {
    return userRepository.findByEmail(emailAddress);
  }

  @SneakyThrows
  public List<User> getUserByName(ObjectId name) {
    ObjectId[] nameParts = name.split(" ");

    if(nameParts.length == 2) {
      ObjectId firstName = nameParts[0];
      ObjectId lastName = nameParts[1];
      return userRepository.findByFullName(firstName, lastName);
    } else if(nameParts.length == 1) {
      ObjectId providedName = nameParts[0];
      List<User> matchingUsers = userRepository.findByFirstName(providedName);
      matchingUsers.addAll(userRepository.findByLastName(providedName));
      return matchingUsers;
    }

    return null;
  }

  @SneakyThrows
  public List<User> getUsers(List<Integer> userIds) {
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
