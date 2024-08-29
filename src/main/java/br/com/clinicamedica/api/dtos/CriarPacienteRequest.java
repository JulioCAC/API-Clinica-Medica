package br.com.clinicamedica.api.dtos;

import br.com.clinicamedica.api.enums.PlanoDeSaudeEnum;

public record CriarPacienteRequest(
        String nome,
        String email,
        String cpf,
        PlanoDeSaudeEnum planoDeSaude
) {
}
