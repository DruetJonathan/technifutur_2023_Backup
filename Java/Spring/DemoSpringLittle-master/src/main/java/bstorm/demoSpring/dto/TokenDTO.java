package bstorm.demoSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TokenDTO {
    private String token;
    private String role;
    private String username;
    private Long id;

    public TokenDTO(String token, String role, String username, Long id) {
        this.token = token;
        this.role = role;
        this.username = username;
        this.id = id;
    }
}
