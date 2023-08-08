package org.example.models.entities;

import lombok.*;

@Builder @AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Customiser {
    private String login,pswd;
    private Integer id;
    public Customiser(String login, String pswd) {
        this.login = login;
        this.pswd = pswd;
    }

    @Override
    public String toString() {
        return "Customiser{" +
                "login='" + login + '\'' +
                ", pswd='" + pswd + '\'' +
                ", id=" + id +
                '}';
    }
}
