package be.bstorm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class Municipality implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne( cascade = CascadeType.PERSIST,
               fetch = FetchType.EAGER)
    private Mayor mayor;

    @ManyToOne( cascade = CascadeType.PERSIST,
                fetch = FetchType.EAGER)
    private Province province;
}
