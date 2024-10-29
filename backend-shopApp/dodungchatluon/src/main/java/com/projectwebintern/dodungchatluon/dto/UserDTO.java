package com.projectwebintern.dodungchatluon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @JsonProperty("fullname")
    @NotBlank(message = "name not null")
    private String fullName;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String address;

    @NotBlank(message = "password not null")
    private String password;

    @JsonProperty("retype_password")
    @NotBlank(message = "retypr password not null")
    private String retypePassword;

    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @JsonProperty("facebook_account_id")
    private int facebookAccountId;

    @JsonProperty("google_account_id")
    private int googleAccountId;

    @NotNull(message = "role id not null")
    @JsonProperty("role_id")
    private Long roleId;
}
