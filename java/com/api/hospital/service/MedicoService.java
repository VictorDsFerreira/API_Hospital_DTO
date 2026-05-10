package com.api.hospital.service;

import com.api.hospital.dto.MedicoRequestDTO;
import com.api.hospital.dto.MedicoResponseDTO;
import com.api.hospital.dto.RegraNegocioException;
import com.api.hospital.model.Medico;
import com.api.hospital.repository.ConsultaRepository;
import com.api.hospital.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    private MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    private MedicoResponseDTO toDTO(Medico medico){
        return MedicoResponseDTO.builder()
                .id(medico.getId())
                .nome(medico.getNome())
                .especialidade(medico.getEspecialidade())
                . build();
    }

    private Medico toEntity(MedicoRequestDTO medicoRequestDTO){
        Medico medico = new Medico();
        medico.setNome(medicoRequestDTO.getNome());
        medico.setEspecialidade(medicoRequestDTO.getEspecialidade());
        medico.setCrm(medicoRequestDTO.getCrm());
        return medico;
    }

    public List<MedicoResponseDTO> todosMedicos(){

        return this.medicoRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public MedicoResponseDTO medicoPorId(Long id){
        Medico medico = this.medicoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Medico não encontrado."));
        return toDTO(medico);
    }

    public MedicoResponseDTO salvarMedico(MedicoRequestDTO medicoRequestDTO){
        Medico medico = toEntity(medicoRequestDTO);
        Medico medicoSalvo = this.medicoRepository.save(medico);
        return toDTO(medicoSalvo);
    }

    public MedicoResponseDTO atualizarMedico(Long id, MedicoRequestDTO medicoRequestDTO){
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Não existe médico com esse id."));
        medico.setNome(medicoRequestDTO.getNome());
        medico.setEspecialidade(medicoRequestDTO.getEspecialidade());
        medico.setCrm(medicoRequestDTO.getCrm());
        Medico atualizado = medicoRepository.save(medico);
        return toDTO(atualizado);
    }

    public String excluirMedico(Long id){
        Medico medico = this.medicoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Medico não encontrado"));
        this.medicoRepository.delete((medico));
        return "Excluido com sucesso";
    }
}
