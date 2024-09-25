package br.com.clinicamedica.api.dtos;

import br.com.clinicamedica.api.enums.EspecialidadeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CriarMedicoRequest(

        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String nome,

        @CPF(message = "CPF inválido")
        String crm,

        @NotNull(message = "A especialidade é obrigatória")
        EspecialidadeEnum especialidade,

        @Email(message = "Email inválido")
        String email,

        @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos (apenas números)")
        String telefone

        ) {
}
