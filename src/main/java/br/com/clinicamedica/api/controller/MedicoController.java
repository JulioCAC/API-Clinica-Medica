package br.com.clinicamedica.api.controller;

import br.com.clinicamedica.api.dtos.CriarMedicoRequest;
import br.com.clinicamedica.api.dtos.MedicoCriadoResponse;
import br.com.clinicamedica.api.model.Medico;
import br.com.clinicamedica.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicoCriadoResponse create(@Valid @RequestBody CriarMedicoRequest criarMedicoRequest){
        return medicoService.create(criarMedicoRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Medico findById(@PathVariable Long id){
        return medicoService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Medico> findAll(){
        return medicoService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Medico update(@PathVariable Long id, @Valid @RequestBody CriarMedicoRequest criarMedicoRequest){
        return medicoService.update(id, criarMedicoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        medicoService.deleteById(id);
    }
}

