package br.com.clinicamedica.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record CriarPacienteRequest(

        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String nome,

        @CPF(message = "CPF inválido")
        String cpf,

        @Email(message = "Email inválido")
        String email,

        @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos (apenas números)")
        String telefone,

        @Past(message = "A data de nascimento deve ser anterior à data atual.")
        LocalDate dataNascimento,

        EnderecoDTO endereco
) {
}
