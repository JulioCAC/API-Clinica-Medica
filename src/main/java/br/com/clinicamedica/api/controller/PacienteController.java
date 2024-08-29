package br.com.clinicamedica.api.controller;

import br.com.clinicamedica.api.dtos.CriarPacienteRequest;
import br.com.clinicamedica.api.dtos.PacienteCriadoResponse;
import br.com.clinicamedica.api.model.Paciente;
import br.com.clinicamedica.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteCriadoResponse create(@RequestBody CriarPacienteRequest criarPacienteRequest){
        return pacienteService.create(criarPacienteRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Paciente findById(@PathVariable Long id){
        return pacienteService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Paciente update(@PathVariable Long id, @RequestBody CriarPacienteRequest criarPacienteRequest){
        return pacienteService.update(id, criarPacienteRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        pacienteService.deleteById(id);
    }
}
