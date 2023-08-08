package com.babiarzdruet.labojavadataweb.models.forms;

import com.babiarzdruet.labojavadataweb.models.entities.Game;
import com.babiarzdruet.labojavadataweb.models.entities.User;
import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class RequestCoachingForm {

    @NotBlank(message = "Name can't be empty")
    @Size (max = 50, message = "Maximum fixed length of 50 characters")
    private String name;

    @NotBlank(message = "Description can't be empty")
    @Size (max = 250, message = "Maximum fixed length of 250 characters")
    private String description;

    @NotBlank(message = "Price can't be empty")
    private Integer price;

    @NotBlank(message = "Image can't be empty")
    private String image;

    private Game game;

    private User user;

    private Boolean pending;
    public RequestCoachingForm toEntity(){

        return new RequestCoachingForm(getName(),getDescription(),getPrice(),getImage(),getGame(),getUser(),getPending());
    }
}
