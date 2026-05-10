package com.api.hospital.controller;

import com.api.hospital.dto.ReceitaRequestDTO;
import com.api.hospital.dto.ReceitaResponseDTO;
import com.api.hospital.model.Receita;
import com.api.hospital.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
    private ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService){
        this.receitaService = receitaService;
    }

    @GetMapping
    public List<ReceitaResponseDTO> todasReceitas(){
        return this.receitaService.todasReceitas();
    }

    @GetMapping("{id}")
    public ReceitaResponseDTO receitaPorId(@PathVariable Long id){
        return this.receitaService.receitaPorId(id);
    }

    @PostMapping
    public ReceitaResponseDTO salvarReceita(@RequestBody @Valid ReceitaRequestDTO receitaRequestDTO){
        return this.receitaService.salvarReceita(receitaRequestDTO);
    }

    @PutMapping("{id}")
    public ReceitaResponseDTO atualizarReceita(@PathVariable Long id, @RequestBody ReceitaRequestDTO receitaRequestDTO){
        return this.receitaService.atualizarReceita(id, receitaRequestDTO);
    }

    @DeleteMapping("{id}")
    public String excluirReceita(@PathVariable Long id){
        return this.receitaService.excluirReceita(id);
    }
}