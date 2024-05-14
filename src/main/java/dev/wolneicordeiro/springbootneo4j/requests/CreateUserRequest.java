package dev.wolneicordeiro.springbootneo4j.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserRequest {
    private String name;
    private String username;
    private String password;
    private String roles;
}
