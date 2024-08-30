package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.user.UserForgotpasswordDTO;
import com.topcare.petshop.controller.dto.user.UserResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NonNull
    private String fullname;

    @Column(nullable = false, unique = true, length = 50)
    @NonNull
    private String email;

    @Column(nullable = false, length = 30)
    @NonNull
    private String password;

    @Column(nullable = false, unique = true, length = 11)
    @NonNull
    private String cpf;

    @Column(nullable = false)
    @Enumerated
    @NonNull
    private UserRole role;

    public User(Long id) {
        this.id = id;
    }

    public UserResponseDTO toDto(){
        return new UserResponseDTO(
                this.id,
                this.fullname,
                this.email,
                this.password,
                this.cpf,
                this.role
        );
    }

    public UserForgotpasswordDTO toForgotPasswordDto(){
        return new UserForgotpasswordDTO(
                this.id,
                this.fullname,
                this.email,
                this.password,
                this.cpf
        );
    }

    public boolean checkPasswords(String passwordToCheck) {
        return this.password.equals(passwordToCheck);
    }

}
