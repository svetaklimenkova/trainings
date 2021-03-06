package by.slivki.trainings.rest.dto;

import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
public class SignUpUserDto {
    @NotNull
    @Size(min = 4, max = 32, message = "form.username.size")
    @Pattern(regexp = "[a-zA-z0-9-.]+", message = "form.username.size")
    private String username;

    @NotNull
    @Size(min = 4, max = 20, message = "form.password.size")
    private String password;

    @NotNull
    @Email
    @Size(min = 6, max = 256, message = "form.email.size")
    private String email;

    private Role role = new Role(RoleEnum.ROLE_USER);

    private boolean isConfirmed = true;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }
}
