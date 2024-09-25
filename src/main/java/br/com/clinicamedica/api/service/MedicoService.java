package br.com.clinicamedica.api.service;

import br.com.clinicamedica.api.dtos.CriarMedicoRequest;

import br.com.clinicamedica.api.dtos.MedicoCriadoResponse;
import br.com.clinicamedica.api.model.Medico;


import java.util.List;

public interface MedicoService {
    MedicoCriadoResponse create(CriarMedicoRequest criarMedicoRequest);
    Medico findById(Long id);
    List<Medico> findAll();
    Medico update(Long id, CriarMedicoRequest criarMedicoRequest);
    void deleteById(Long id);
}
