package com.sistemahospitalar.sistemahospitalar.controller;

import com.sistemahospitalar.sistemahospitalar.dto.MedicoRequestDTO;
import com.sistemahospitalar.sistemahospitalar.dto.MedicoResponseDTO;
import com.sistemahospitalar.sistemahospitalar.model.Medico;
import com.sistemahospitalar.sistemahospitalar.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<MedicoResponseDTO> todasMedicos(){
        return this.medicoService.todosMedicos();
    }

    @GetMapping("{id}")
    public MedicoResponseDTO medicoPorId(@PathVariable Long id){
        return this.medicoService.medicoPorId(id);
    }

    @PostMapping
    public MedicoResponseDTO salvarMedico(@RequestBody @Valid MedicoRequestDTO medicoRequestDTO){
        return this.medicoService.salvarMedico(medicoRequestDTO);
    }

    @PutMapping("{id}")
    public MedicoResponseDTO atualizarMedico(@PathVariable Long id, @RequestBody MedicoRequestDTO medicoRequestDTO){
        return this.medicoService.atualizarMedico(id, medicoRequestDTO);
    }

    @DeleteMapping("{id}")
    public String excluirMedico(@PathVariable Long id){
        return this.medicoService.excluirMedico(id);
    }
}
