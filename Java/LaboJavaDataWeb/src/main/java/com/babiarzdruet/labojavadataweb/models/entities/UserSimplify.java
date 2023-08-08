package com.babiarzdruet.labojavadataweb.models.entities;

import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter @EqualsAndHashCode
public class UserSimplify {

    private Set<Role> roles;
    private Long id;
    private String email;

    public UserSimplify(String email, Set<Role> roles) {
        this.email = email;
        this.roles = roles;
    }
}