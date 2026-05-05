package com.sistemahospitalar.sistemahospitalar.service;

import com.sistemahospitalar.sistemahospitalar.dto.PacienteRequestDTO;
import com.sistemahospitalar.sistemahospitalar.dto.PacienteResponseDTO;
import com.sistemahospitalar.sistemahospitalar.model.Paciente;
import com.sistemahospitalar.sistemahospitalar.model.Paciente;
import com.sistemahospitalar.sistemahospitalar.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    private PacienteResponseDTO toDTO(Paciente paciente){
        return PacienteResponseDTO.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .telefone(paciente.getTelefone())
                . build();
    }

    private Paciente toEntity(PacienteRequestDTO pacienteRequestDTO){
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteRequestDTO.getNome());
        paciente.setCpf(pacienteRequestDTO.getCpf());
        paciente.setTelefone(pacienteRequestDTO.getTelefone());
        return paciente;
    }

    public List<PacienteResponseDTO> todosPacientes(){

        return this.pacienteRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public PacienteResponseDTO pacientePorId(Long id){
        Paciente paciente = this.pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado."));
        return toDTO(paciente);
    }

    public PacienteResponseDTO salvarPaciente(PacienteRequestDTO pacienteRequestDTO){
        Paciente paciente = toEntity(pacienteRequestDTO);
        Paciente pacienteSalvo = this.pacienteRepository.save(paciente);
        return toDTO(pacienteSalvo);
    }

    public PacienteResponseDTO atualizarPaciente(Long id, PacienteRequestDTO pacienteRequestDTO){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        paciente.setNome(pacienteRequestDTO.getNome());
        paciente.setCpf(pacienteRequestDTO.getCpf());
        paciente.setTelefone(pacienteRequestDTO.getTelefone());
        Paciente atualizado = pacienteRepository.save(paciente);
        return toDTO(atualizado);
    }

    public String excluirPaciente(Long id){
        Paciente paciente = this.pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        this.pacienteRepository.delete((paciente));
        return "Excluido com sucesso";
    }
}
