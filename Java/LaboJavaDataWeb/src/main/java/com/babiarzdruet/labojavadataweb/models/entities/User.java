package com.babiarzdruet.labojavadataweb.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "Users")
@Entity @Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 50) @Getter @Setter
    String firstname;

    @Column(length = 50) @Getter @Setter
    String lastname;

    @Email(message = "Invalid email format") @Getter @Setter
    String email;

    @Column(length = 250)
    String password;

    @Getter @Setter
    String profileImage;

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    @Setter
    private Set<RequestCoaching> requestCoachingSet;



    public Set<RequestCoaching> getRequestCoaching() {
        return new HashSet<>(this.requestCoachingSet);
    }

    public void addRequestCoaching(RequestCoaching requestCoaching) {
        requestCoachingSet.add(requestCoaching);
    }

    public void removeRequestCoaching(RequestCoaching requestCoaching) {
        requestCoachingSet.remove(requestCoaching);
    }

    public User() {
        this.roles = new HashSet<>();
        this.requestCoachingSet = new HashSet<>();
    }

    public User(String firstname, String lastname, String email, String password, String profileImage) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
    }

    public Set<Role> getRoles() {
        return new HashSet<>(this.roles);
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }
}
