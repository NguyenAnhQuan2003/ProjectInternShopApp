package com.projectwebintern.dodungchatluon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserLoginDTO {
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank(message = "password not null")
    private String password;
}
