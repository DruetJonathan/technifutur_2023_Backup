package com.babiarzdruet.labojavadataweb.models.forms;

import com.babiarzdruet.labojavadataweb.models.entities.Role;
import com.babiarzdruet.labojavadataweb.models.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class UserForm {

        @NotBlank(message = "Firstname can't be empty")
        @Size(max = 50, message = "Maximum fixed length of 50 characters")
        private String firstname;

        @NotBlank(message = "Lastname can't be empty")
        @Size(max = 50, message = "Maximum fixed length of 50 characters")
        private String lastname;

        @NotBlank(message = "Email can't be empty")
        @Size(max = 100, message = "Maximum fixed length of 100 characters")
        private String email;

        @NotBlank(message = "Password can't be empty")
        @Size(max = 250, message = "Maximum fixed length of 250 characters")
        private String password;

        private String profileImage;

        public User toEntity(){

            return new User(getFirstname(),getLastname(),getEmail(),getPassword(),getProfileImage());
        }
}

