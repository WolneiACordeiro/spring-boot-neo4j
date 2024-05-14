package dev.wolneicordeiro.springbootneo4j.controllers;

import dev.wolneicordeiro.springbootneo4j.models.User;
import dev.wolneicordeiro.springbootneo4j.objects.UserDTO;
import dev.wolneicordeiro.springbootneo4j.requests.CreateUserRequest;
import dev.wolneicordeiro.springbootneo4j.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/me")
    public String loggedInUser(Principal principal){
        return principal.getName();
    }
    @PostMapping("/register")
    public ResponseEntity<UserDTO> signUp(@RequestBody CreateUserRequest request){
        User user = userService.createUser(request);
        UserDTO responseUser = new UserDTO(user.getName(), user.getUsername(), user.getRoles());
        return new ResponseEntity<>(responseUser, HttpStatus.CREATED);
    }
}
