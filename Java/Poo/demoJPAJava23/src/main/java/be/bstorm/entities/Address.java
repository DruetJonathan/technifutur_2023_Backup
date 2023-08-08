package be.bstorm.entities;


import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Address {

    private String address;
}
