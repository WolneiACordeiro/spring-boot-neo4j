package dev.wolneicordeiro.springbootneo4j.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {
   private String name;
   private String username;
   private String roles;
}
