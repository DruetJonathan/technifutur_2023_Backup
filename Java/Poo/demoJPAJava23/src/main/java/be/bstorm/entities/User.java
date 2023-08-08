package be.bstorm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

//@Access(value = AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "getByBirthdate",
                    query = "select u from User u where year(u.birthdate) < :year ")
})
@Entity
@Table(name = "CUSTOMER",
       uniqueConstraints = {@UniqueConstraint( name = "UK_CUSTOMER__FIRST_NAME__LAST_NAME",
                                               columnNames = {"FIRST_NAME","LAST_NAME"})})
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME",length = 40)
    private String firstname;

    @Column(name = "LAST_NAME",length = 60)
    private String lastname;

    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;

    @Column(name = "GENDER",length = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @OrderColumn(name = "index")
    @ElementCollection
    private List<String> friends;
}
