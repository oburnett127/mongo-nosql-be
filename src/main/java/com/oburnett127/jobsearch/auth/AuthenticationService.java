package com.oburnett127.jobsearch.auth;

import com.oburnett127.jobsearch.config.JwtService;
import com.oburnett127.jobsearch.model.Employer;
import com.oburnett127.jobsearch.service.EmployerService;
import com.oburnett127.jobsearch.token.Token;
import com.oburnett127.jobsearch.token.TokenRepository;
import com.oburnett127.jobsearch.token.TokenType;
import com.oburnett127.jobsearch.user.Role;
import com.oburnett127.jobsearch.user.User;
import com.oburnett127.jobsearch.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final EmployerService employerService;

  public AuthenticationResponse register(RegisterRequest request) {
    //Check to see if account with email already exists
    Optional<User> existingUser = repository.findByEmail(request.getEmail());
    
    if(existingUser.isPresent()) return null; 
    
    var user = new User();

    if(request.getIsEmployer() == false) {
      System.out.println("role is: USER");
      user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    } else {
      System.out.println("role is: EMPLOYER");

      String employerName = request.getEmployerName();
      Optional<Employer> employer = employerService.getEmployerByName(employerName);
      Employer emp = new Employer();

      if(employer.isPresent()) {
        emp = employer.get();
        int empId = emp.getId();

        user = User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .employerId(empId)
            .role(Role.EMPLOYER)
            .build();
      }
    }

    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(savedUser, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
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
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
