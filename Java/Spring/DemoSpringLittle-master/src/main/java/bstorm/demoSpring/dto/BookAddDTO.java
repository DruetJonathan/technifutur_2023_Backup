package bstorm.demoSpring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter @Setter
public class BookAddDTO {

    @NotBlank
    @NotNull
    @Length(max = 255)
    private String title;

    @Length(max = 65535)
    private String description;

    private Date realeaseDate;

    @NotBlank
    @NotNull
    private String isbn;

    private byte[] imageBlob;

    private String imageExt;
}
