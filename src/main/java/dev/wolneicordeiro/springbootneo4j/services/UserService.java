package dev.wolneicordeiro.springbootneo4j.services;

import dev.wolneicordeiro.springbootneo4j.models.User;
import dev.wolneicordeiro.springbootneo4j.repositories.UserRepository;
import dev.wolneicordeiro.springbootneo4j.requests.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(CreateUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setRoles(request.getRoles());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return user;
    }
}
