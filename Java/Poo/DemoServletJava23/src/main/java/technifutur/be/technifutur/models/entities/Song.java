package technifutur.be.technifutur.models.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter @EqualsAndHashCode
public class Song {
    private Integer id;
    private String libele;
    private String emplacement_link;
}
