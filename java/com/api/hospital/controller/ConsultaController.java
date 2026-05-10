package com.api.hospital.controller;

import com.api.hospital.dto.ConsultaRequestDTO;
import com.api.hospital.dto.ConsultaResponseDTO;
import com.api.hospital.model.Consulta;
import com.api.hospital.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService){
        this.consultaService = consultaService;
    }

    @GetMapping
    public List<ConsultaResponseDTO> todasConsultas(){
        return this.consultaService.todasConsultas();
    }

    @GetMapping("{id}")
    public ConsultaResponseDTO consultaPorId(@PathVariable Long id){
        return this.consultaService.consultaPorId(id);
    }

    @PostMapping
    public ConsultaResponseDTO salvarConsulta(@RequestBody @Valid ConsultaRequestDTO consultaRequestDTO){
        return this.consultaService.salvarConsulta(consultaRequestDTO);
    }

    @PutMapping("{id}")
    public ConsultaResponseDTO atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaRequestDTO consultaRequestDTO){
        return this.consultaService.atualizarConsulta(id, consultaRequestDTO);
    }

    @DeleteMapping("{id}")
    public String excluirConsulta(@PathVariable Long id){
        return this.consultaService.excluirConsulta(id);
    }
}