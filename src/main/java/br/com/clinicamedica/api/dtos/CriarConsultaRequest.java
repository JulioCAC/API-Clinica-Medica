package br.com.clinicamedica.api.dtos;


import br.com.clinicamedica.api.enums.StatusEnum;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record CriarConsultaRequest(

        @NotNull(message = "O paciente é obrigatório")
        Long pacienteId,

        @NotNull(message = "O médico é obrigatório")
        Long medicoId,

        @NotNull(message = "A data da consulta é obrigatória")
        @Future(message = "A consulta deve ser agendada para uma data futura")
        LocalDateTime dataConsulta,

        @NotBlank(message = "O motivo é obrigatório")
        @Size(max = 10, message = "O motivo deve ter no máximo 10 caracteres")
        String motivo,

        @NotNull(message = "O status é obrigatório")
        StatusEnum status
) {
}
