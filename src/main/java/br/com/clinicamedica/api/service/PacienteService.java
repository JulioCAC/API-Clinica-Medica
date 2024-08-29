package br.com.clinicamedica.api.service;

import br.com.clinicamedica.api.dtos.CriarPacienteRequest;
import br.com.clinicamedica.api.dtos.PacienteCriadoResponse;
import br.com.clinicamedica.api.model.Paciente;

import java.util.List;

public interface PacienteService {
    PacienteCriadoResponse create(CriarPacienteRequest criarPacienteRequest);
    Paciente findById(Long id);
    List<Paciente> findAll();
    Paciente update(Long id, CriarPacienteRequest criarPacienteRequest);
    void deleteById(Long id);
}
