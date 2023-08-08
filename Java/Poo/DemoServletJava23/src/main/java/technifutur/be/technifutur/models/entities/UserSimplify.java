package technifutur.be.technifutur.models.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter @EqualsAndHashCode
public class UserSimplify {

    private Integer id;
    private String username;
    private String email;

    public UserSimplify(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
