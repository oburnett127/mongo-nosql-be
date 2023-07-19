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
import com.oburnett127.socialmedia.model.User;
import com.oburnett127.socialmedia.model.request.AuthenticationRequest;
import com.oburnett127.socialmedia.model.request.RegisterRequest;
import com.oburnett127.socialmedia.model.response.AuthenticationResponse;
import com.oburnett127.socialmedia.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
    System.out.println("$$$$$$$$$$$$ ----------- inside UserController.register");
    Optional<User> existingUser = userService.getUserByEmail(request.getEmail());
    
    if(existingUser.isPresent()) return ResponseEntity.status(409).body(new AuthenticationResponse(null));
    
    AuthenticationResponse response = userService.register(request);
    
    return ResponseEntity.status(200).body(response);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
    @RequestBody AuthenticationRequest request) {
    System.out.println("$$$$$$$$$$$$ ----------- inside UserController.authenticate");
    return ResponseEntity.ok(userService.authenticate(request));
  }

  @GetMapping("/getrole/{userId}")
  public ResponseEntity<String> getRoleByUserId(@Validated @PathVariable int userId) {
    System.out.println("$$$$$$$$$$$$ ----------- inside UserController.getRoleByUserId");
    final String role = userService.getRoleByUserId(userId).toString();
    return ResponseEntity.ok().body(role);
  }

  @GetMapping("/getuserid/{email}")
  public ResponseEntity<Integer> getUserIdByEmail(@Validated @PathVariable String email) {
    System.out.println("$$$$$$$$$$$$ ----------- inside UserController.getUserIdByEmail");
    final var userId = userService.getUserIdByEmail(email);
    return ResponseEntity.ok().body(userId);
  }

  @GetMapping(value = "/getuser/{email}", produces = "application/json")
  public ResponseEntity<User> getUserByEmail(@Validated @PathVariable String email) {
    System.out.println("$$$$$$$$$$$$ ----------- inside UserController.getUserByEmail");
    final var user = userService.getUserByEmail(email);
    return ResponseEntity.ok().body(user.get());
  }
}