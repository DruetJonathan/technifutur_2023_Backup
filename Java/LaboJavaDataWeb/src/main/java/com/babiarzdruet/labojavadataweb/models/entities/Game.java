package com.babiarzdruet.labojavadataweb.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Game", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name"})})
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 50)
    String name;

    public Game(String name) {
        this.name = name;
    }
    public Game() {

    }
}
