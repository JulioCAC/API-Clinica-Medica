package br.com.clinicamedica.api.service;

import br.com.clinicamedica.api.dtos.CriarPacienteRequest;
import br.com.clinicamedica.api.dtos.PacienteCriadoResponse;
import br.com.clinicamedica.api.model.Endereco;
import br.com.clinicamedica.api.model.Paciente;
import br.com.clinicamedica.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;


    @Override
    public PacienteCriadoResponse create(CriarPacienteRequest criarPacienteRequest) {
        Endereco endereco = new Endereco(
                null,
                criarPacienteRequest.endereco().logradouro(),
                criarPacienteRequest.endereco().numero(),
                criarPacienteRequest.endereco().complemento(),
                criarPacienteRequest.endereco().bairro(),
                criarPacienteRequest.endereco().cidade(),
                criarPacienteRequest.endereco().estado(),
                criarPacienteRequest.endereco().pais(),
                criarPacienteRequest.endereco().cep()
        );
        Paciente paciente = new Paciente();
        paciente.setNome(criarPacienteRequest.nome());
        paciente.setCpf(criarPacienteRequest.cpf());
        paciente.setEmail(criarPacienteRequest.email());
        paciente.setTelefone(criarPacienteRequest.telefone());
        paciente.setDataNascimento(criarPacienteRequest.dataNascimento());
        paciente.setEndereco(endereco);


        Paciente pacienteCriado = pacienteRepository.save(paciente);

        return new PacienteCriadoResponse(
                "Paciente criado com sucesso",
                 pacienteCriado.getId()
        );
    }

    @Override
    public Paciente findById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
    }


    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente update(Long id, CriarPacienteRequest criarPacienteRequest) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

        pacienteExistente.setNome(criarPacienteRequest.nome());
        pacienteExistente.setCpf(criarPacienteRequest.cpf());
        pacienteExistente.setEmail(criarPacienteRequest.email());
        pacienteExistente.setTelefone(criarPacienteRequest.telefone());
        pacienteExistente.setDataNascimento(criarPacienteRequest.dataNascimento());


        return pacienteRepository.save(pacienteExistente);

    }

    @Override
    public void deleteById(Long id) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
        pacienteRepository.deleteById(pacienteExistente.getId());
    }
}
