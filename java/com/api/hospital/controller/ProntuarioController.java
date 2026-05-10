package com.api.hospital.controller;

import com.api.hospital.dto.ProntuarioRequestDTO;
import com.api.hospital.dto.ProntuarioResponseDTO;
import com.api.hospital.model.Prontuario;
import com.api.hospital.service.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {
    private ProntuarioService prontuarioService;

    public ProntuarioController(ProntuarioService prontuarioService){
        this.prontuarioService = prontuarioService;
    }

    @GetMapping
    public List<ProntuarioResponseDTO> todasProntuarios(){
        return this.prontuarioService.todosProntuarios();
    }

    @GetMapping("{id}")
    public ProntuarioResponseDTO prontuarioPorId(@PathVariable Long id){
        return this.prontuarioService.prontuarioPorId(id);
    }

    @PostMapping
    public ProntuarioResponseDTO salvarProntuario(@RequestBody @Valid ProntuarioRequestDTO prontuarioRequestDTO){
        return this.prontuarioService.salvarProntuario(prontuarioRequestDTO);
    }

    @PutMapping("{id}")
    public ProntuarioResponseDTO atualizarProntuario(@PathVariable Long id, @RequestBody ProntuarioRequestDTO prontuarioRequestDTO){
        return this.prontuarioService.atualizarProntuario(id, prontuarioRequestDTO);
    }

    @DeleteMapping("{id}")
    public String excluirProntuario(@PathVariable Long id){
        return this.prontuarioService.excluirProntuario(id);
    }
}