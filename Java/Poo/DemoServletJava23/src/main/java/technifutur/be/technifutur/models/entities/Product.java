package technifutur.be.technifutur.models.entities;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter @EqualsAndHashCode
public class Product {
    private Integer id;
    private String libele;
    private String description;
    private BigDecimal price;

    public Product(String libele, String description, BigDecimal price) {
        this.libele = libele;
        this.description = description;
        this.price = price;
    }
}

