package be.bstorm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Mayor implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "mayor")
    private Municipality municipality;

    @Override
    public String toString() {
        return "Mayor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
