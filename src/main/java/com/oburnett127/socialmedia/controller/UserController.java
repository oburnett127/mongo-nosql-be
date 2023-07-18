package com.oburnett127.socialmedia.controller;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oburnett127.socialmedia.model.Friend;
import com.oburnett127.socialmedia.model.User;
import com.oburnett127.socialmedia.model.request.AuthenticationRequest;
import com.oburnett127.socialmedia.model.request.RegisterRequest;
import com.oburnett127.socialmedia.model.response.AuthenticationResponse;
import com.oburnett127.socialmedia.service.EmployerService;
import com.oburnett127.socialmedia.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final EmployerService employerService;

  @PostMapping("/signup")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
    Optional<User> existingUser = userService.getUserByEmail(request.getEmail());

    if(existingUser.isPresent()) return ResponseEntity.status(409).body(new AuthenticationResponse(null));

    int empId = 0;

    if(request.getIsEmployer()) {
      String employerName = request.getEmployerName();
      Optional<Friend> employer = employerService.getEmployerByName(employerName);
      Friend emp;
      
      if(employer.isPresent()) {
        emp = employer.get();
        empId = emp.getId();
        System.out.println("employer is present - empId is: " + empId);
      } else {
        empId = employerService.getMaxEmployerId() + 1;
        System.out.println("generated empId: " + empId);
        emp = new Friend(empId, employerName);
        employerService.createEmployer(emp);
      }

      System.out.println(empId);
    }

    AuthenticationResponse response = userService.register(request, empId);
    
    return ResponseEntity.status(200).body(response);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request) {
      return ResponseEntity.ok(userService.authenticate(request));
  }

  @GetMapping("/getrole/{userId}")
  public ResponseEntity<String> getRoleByUserId(@Validated @PathVariable int userId) {
      final String role = userService.getRoleByUserId(userId).toString();
      return ResponseEntity.ok().body(role);
  }

  @GetMapping("/getuserid/{email}")
  public ResponseEntity<Integer> getUserIdByEmail(@Validated @PathVariable String email) {
      System.out.println("$$$$$$$$$$$$ ----------- inside getUserIdByEmail");
      final var userId = userService.getUserIdByEmail(email);
      return ResponseEntity.ok().body(userId);
  }

  @GetMapping(value = "/getuser/{email}", produces = "application/json")
  public ResponseEntity<User> getUserByEmail(@Validated @PathVariable String email) {
    System.out.println("$$$$$$$$$$$$ ----------- inside getUserByEmail");
    final var user = userService.getUserByEmail(email);
    return ResponseEntity.ok().body(user.get());
  }
}
