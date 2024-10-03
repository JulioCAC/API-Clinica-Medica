package br.com.clinicamedica.api.dtos;

import jakarta.validation.constraints.*;

public record CriarMedicoRequest(

        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String nome,

        @Size(min = 5, max = 8, message = "O CRM deve ter entre 5 e 8 dígitos")
        String crm,

        @NotBlank(message = "A especialidade é obrigatória")
        String especialidade,

        @Email(message = "Email inválido")
        String email,

        @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos (apenas números)")
        String telefone

        ) {
}
