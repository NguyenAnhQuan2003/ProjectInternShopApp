package com.projectwebintern.dodungchatluon.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    @NotBlank(message = "không để name null")
    private String name;
}
