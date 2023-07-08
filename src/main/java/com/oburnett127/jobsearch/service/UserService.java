package com.oburnett127.jobsearch.service;

import com.oburnett127.jobsearch.model.Employer;
import com.oburnett127.jobsearch.model.Role;
import com.oburnett127.jobsearch.model.Token;
import com.oburnett127.jobsearch.model.TokenType;
import com.oburnett127.jobsearch.model.User;
import com.oburnett127.jobsearch.model.request.AuthenticationRequest;
import com.oburnett127.jobsearch.model.request.RegisterRequest;
import com.oburnett127.jobsearch.model.response.AuthenticationResponse;
import com.oburnett127.jobsearch.repository.EmployerRepository;
import com.oburnett127.jobsearch.repository.TokenRepository;
import com.oburnett127.jobsearch.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final EmployerService employerService;
  private final EmployerRepository employerRepository;

  public AuthenticationResponse register(RegisterRequest request) {
    //Check to see if account with email already exists
    Optional<User> existingUser = repository.findByEmail(request.getEmail());
    
    if(existingUser.isPresent()) return null; 
    
    var user = new User();

    if(request.getIsEmployer() == false) {
      System.out.println("role is: USER");
      user = User.builder()
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    } else {
      System.out.println("role is: EMPLOYER");
      String employerName = request.getEmployerName();
      Optional<Employer> employer = employerService.getEmployerByName(employerName);
      Employer emp;
      int empId;

      if(employer.isPresent()) {
        emp = employer.get();
        empId = emp.getId();
        System.out.println("employer is present - empId is: " + empId);
      } else {
        empId = employerRepository.getMaxEmployerId() + 1;
        System.out.println("generated empId: " + empId);
        emp = new Employer(empId, employerName);
        employerService.createEmployer(emp);
      }

      System.out.println(empId);

      user = User.builder()
          .email(request.getEmail())
          .password(passwordEncoder.encode(request.getPassword()))
          .employerId(empId)
          .role(Role.EMPLOYER)
          .build();
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

  public Role getRoleByUserId(int userId) {
    Optional<User> user = repository.findById(userId);
    User account = user.get();
    return account.getRole();
  }

  public Employer getEmployerByEmail(String emailAddress) {
    Optional<User> user = repository.findByEmail(emailAddress);
    User account = user.get();
    int empId = account.getEmployerId();
    Optional<Employer> employer = employerRepository.findById(empId);
    return employer.get();
  }

  public int getUserIdByEmail(String emailAddress) {
    Optional<User> user = repository.findByEmail(emailAddress);
    int userId = user.get().getId();
    return userId;
  }

  public User getUserByEmail(String emailAddress) {
    Optional<User> user = repository.findByEmail(emailAddress);
    if(user.get() != null) return user.get();
    else return null;
  }
}