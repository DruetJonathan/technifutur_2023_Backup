package com.babiarzdruet.labojavadataweb.models.forms;

import com.babiarzdruet.labojavadataweb.models.entities.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameForm {

    @NotBlank(message = "Name can't be empty")
    @Size(max = 50, message = "Maximum fixed length of 50 characters")
    private String name;

    public Game toEntity(){

        return new Game(getName());
    }
}
