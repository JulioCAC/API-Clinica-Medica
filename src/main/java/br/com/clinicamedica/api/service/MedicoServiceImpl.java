package br.com.clinicamedica.api.service;

import br.com.clinicamedica.api.dtos.CriarMedicoRequest;
import br.com.clinicamedica.api.dtos.CriarPacienteRequest;
import br.com.clinicamedica.api.dtos.MedicoCriadoResponse;
import br.com.clinicamedica.api.model.Medico;
import br.com.clinicamedica.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService{

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public MedicoCriadoResponse create(CriarMedicoRequest criarMedicoRequest) {

        Optional<Medico> medicoExistente = medicoRepository.findByCrm(criarMedicoRequest.crm());
        if (medicoExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um médico cadastrado com o CRM: " + criarMedicoRequest.crm());
        }

        Medico medico = new Medico();
        medico.setNome(criarMedicoRequest.nome());
        medico.setCrm(criarMedicoRequest.crm());
        medico.setEspecialidade(criarMedicoRequest.especialidade());
        medico.setEmail(criarMedicoRequest.email());
        medico.setTelefone(criarMedicoRequest.telefone());

        Medico medicoCriado = medicoRepository.save(medico);

        return new MedicoCriadoResponse(
                "Paciente criado com sucesso",
                medicoCriado.getId()
        );
    }

    @Override
    public Medico findById(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico não encontrado"));
    }

    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico update(Long id, CriarMedicoRequest criarMedicoRequest) {
        Medico medicoExistente = medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico não encontrado"));

        Optional<Medico> medicoComMesmoCrm = medicoRepository.findByCrm(criarMedicoRequest.crm());
        if (medicoComMesmoCrm.isPresent() && !medicoComMesmoCrm.get().getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um médico cadastrado com o CRM: " + criarMedicoRequest.crm());
        }

        medicoExistente.setNome(criarMedicoRequest.nome());
        medicoExistente.setCrm(criarMedicoRequest.crm());
        medicoExistente.setEspecialidade(criarMedicoRequest.especialidade());
        medicoExistente.setEmail(criarMedicoRequest.email());
        medicoExistente.setTelefone(criarMedicoRequest.telefone());

        return medicoRepository.save(medicoExistente);
    }


    @Override
    public void deleteById(Long id) {
        Medico medicoExistente = medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico não encontrado"));
        medicoRepository.deleteById(medicoExistente.getId());
    }
}
