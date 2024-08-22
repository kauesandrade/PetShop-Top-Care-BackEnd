package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.user.ForgotPasswordResponseDTO;
import com.topcare.petshop.controller.dto.user.UserResponseDTO;
import jakarta.persistence.*;
import lombok.*;

/**
 * A classe User representa um usuário abstrato do sistema, que pode ser um cliente,
 * administrador, gerente ou veterinário.
 *
 * Cada usuário possui um nome completo, email, senha, CPF e um papel (role) definido.
 *
 * Anotações:
 * - @Entity: Define que a classe será mapeada para uma tabela no banco de dados.
 * - @Inheritance(strategy = InheritanceType.JOINED): Define a estratégia de herança para as subclasses.
 * - @Data: Gera automaticamente getters, setters, equals, hashCode e toString.
 * - @AllArgsConstructor: Gera um construtor com todos os atributos da classe.
 * - @NoArgsConstructor: Gera um construtor sem argumentos.
 * - @RequiredArgsConstructor: Gera um construtor que inicializa os campos marcados com @NonNull.
 * - @Id e @GeneratedValue: Define o identificador único da entidade com geração automática de ID.
 * - @Column: Configura as propriedades das colunas no banco de dados.
 * - @Enumerated: Mapeia a enumeração UserRole para o banco de dados.
 */
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
    private String fullname; /** Nome completo do usuário*/

    @Column(nullable = false, unique = true, length = 50)
    @NonNull
    private String email; /** Email do usuário, deve ser único no sistema*/

    @Column(nullable = false, length = 30)
    @NonNull
    private String password; /** Senha do usuário*/

    @Column(nullable = false, unique = true, length = 11)
    @NonNull
    private String cpf; /** CPF do usuário, deve ser único no sistema*/

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private UserRole role; /** Papel do usuário no sistema (Ex: ADMIN, CUSTOMER)*/

    /**
     * Construtor que recebe apenas o ID do usuário.
     *
     * @param id Identificador único do usuário
     */
    public User(Long id) {
        this.id = id;
    }

    /**
     * Converte o objeto User para um DTO de resposta de usuário.
     *
     * @return UserResponseDTO contendo os dados do usuário
     */
    public UserResponseDTO toDto(){
        return new UserResponseDTO(
                this.fullname,
                this.email,
                this.password,
                this.cpf,
                this.role
        );
    }

    /**
     * Verifica se a senha fornecida corresponde à senha do usuário.
     *
     * @param passwordToCheck A senha a ser verificada
     * @return true se as senhas coincidirem, caso contrário false
     */
    public boolean checkPasswords(String passwordToCheck) {
        return this.password.equals(passwordToCheck);
    }

}
