package com.topcare.petshop.service.user;

import com.topcare.petshop.controller.dto.user.*;
import org.springframework.stereotype.Service;
/**
 * Interface para serviços relacionados ao usuário.
 * Define métodos para login, verificação de e-mail para recuperação de senha e alteração de senha.
 */
@Service
public interface UserServiceInt {

    /**
     * Realiza o login do usuário com base no e-mail e senha fornecidos.
     *
     * @param dto DTO contendo e-mail e senha do usuário.
     * @return DTO contendo informações do usuário autenticado.
     * @throws Exception Se as credenciais estiverem incorretas.
     */
    UserResponseDTO doLogin(UserRequestPostDTO dto) throws Exception;

    /**
     * Verifica o e-mail do usuário para recuperação de senha.
     *
     * @param dto DTO contendo o e-mail do usuário.
     * @return DTO contendo o ID do usuário e um código de verificação para recuperação de senha.
     * @throws Exception Se o e-mail não estiver cadastrado.
     */
    UserForgotPasswordDTO verifyEmail(UserEmailRequestDTO dto) throws Exception;

    /**
     * Altera a senha do usuário com base no ID e nova senha fornecidos.
     *
     * @param id ID do usuário cuja senha será alterada.
     * @param dto DTO contendo a nova senha.
     * @throws Exception Se o usuário não existir.
     */
    void changePassword(Long id, NewPasswordRequestDTO dto) throws Exception;

    ForgotPasswordCodeResponseDTO getCode();
}
