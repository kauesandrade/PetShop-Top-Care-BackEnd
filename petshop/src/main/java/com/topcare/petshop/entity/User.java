package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.user.UserResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

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

    public UserResponseDTO toDto(){
        return new UserResponseDTO(
                this.fullname,
                this.email,
                this.password,
                this.cpf,
                this.role
        );
    }
}
