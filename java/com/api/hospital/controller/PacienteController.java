package com.api.hospital.controller;

import com.api.hospital.dto.PacienteRequestDTO;
import com.api.hospital.dto.PacienteResponseDTO;
import com.api.hospital.model.Paciente;
import com.api.hospital.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<PacienteResponseDTO> todasPacientes(){
        return this.pacienteService.todosPacientes();
    }

    @GetMapping("{id}")
    public PacienteResponseDTO pacientePorId(@PathVariable Long id){
        return this.pacienteService.pacientePorId(id);
    }

    @PostMapping
    public PacienteResponseDTO salvarPaciente(@RequestBody @Valid PacienteRequestDTO pacienteRequestDTO){
        return this.pacienteService.salvarPaciente(pacienteRequestDTO);
    }

    @PutMapping("{id}")
    public PacienteResponseDTO atualizarPaciente(@PathVariable Long id, @RequestBody PacienteRequestDTO pacienteRequestDTO){
        return this.pacienteService.atualizarPaciente(id, pacienteRequestDTO);
    }

    @DeleteMapping("{id}")
    public String excluirPaciente(@PathVariable Long id){
        return this.pacienteService.excluirPaciente(id);
    }
}