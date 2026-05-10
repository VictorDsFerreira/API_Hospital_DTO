package com.api.hospital.controller;



import com.api.hospital.dto.ConvenioRequestDTO;
import com.api.hospital.dto.ConvenioResponseDTO;
import com.api.hospital.model.Convenio;
import com.api.hospital.service.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {
    private ConvenioService convenioService;

    public ConvenioController(ConvenioService convenioService){
        this.convenioService = convenioService;
    }

    @GetMapping
    public List<ConvenioResponseDTO> todasConvenios(){
        return this.convenioService.todosConvenios();
    }

    @GetMapping("{id}")
    public ConvenioResponseDTO convenioPorId(@PathVariable Long id){
        return this.convenioService.convenioPorId(id);
    }

    @PostMapping
    public ConvenioResponseDTO salvarConvenio(@RequestBody @Valid ConvenioRequestDTO convenioRequestDTO){
        return this.convenioService.salvarConvenio(convenioRequestDTO);
    }

    @PutMapping("{id}")
    public ConvenioResponseDTO atualizarConvenio(@PathVariable Long id, @RequestBody ConvenioRequestDTO convenioRequestDTO){
        return this.convenioService.atualizarConvenio(id, convenioRequestDTO);
    }

    @DeleteMapping("{id}")
    public String excluirConvenio(@PathVariable Long id){
        return this.convenioService.excluirConvenio(id);
    }
}
