package org.devhamzat.userauthentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.devhamzat.userauthentication.utils.ValidPassword;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    @NotEmpty
    private String email;
    @ValidPassword
    @NotEmpty
    private String password;
    private String userName;
}
