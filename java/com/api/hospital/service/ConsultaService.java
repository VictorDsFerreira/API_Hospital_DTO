package com.api.hospital.service;

import com.api.hospital.dto.ConsultaRequestDTO;
import com.api.hospital.dto.ConsultaResponseDTO;
import com.api.hospital.dto.RegraNegocioException;
import com.api.hospital.model.Consulta;
import com.api.hospital.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    private ConsultaResponseDTO toDTO(Consulta consulta){
        return ConsultaResponseDTO.builder()
                .id(consulta.getId())
                .dataHora(consulta.getDataHora())
                .motivo(consulta.getMotivo())
                .valor(consulta.getId())
                .paciente(consulta.getPaciente())
                .medico(consulta.getMedico())
                .convenio(consulta.getConvenio())
                .receita(consulta.getReceita())
                . build();
    }

    private Consulta toEntity(ConsultaRequestDTO consultaRequestDTO){
        Consulta consulta = new Consulta();
        consulta.setDataHora(consultaRequestDTO.getDataHora());
        consulta.setMotivo(consultaRequestDTO.getMotivo());
        consulta.setValor(consultaRequestDTO.getValor());
        consulta.setPaciente(consultaRequestDTO.getPaciente());
        consulta.setMedico(consultaRequestDTO.getMedico());
        consulta.setConvenio(consultaRequestDTO.getConvenio());
        consulta.setReceita(consultaRequestDTO.getReceita());
        return consulta;
    }

    public List<ConsultaResponseDTO> todasConsultas(){

        return this.consultaRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ConsultaResponseDTO consultaPorId(Long id){
        Consulta consulta = this.consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada."));
        return toDTO(consulta);
    }

    public ConsultaResponseDTO salvarConsulta(ConsultaRequestDTO consultaRequestDTO){
        Consulta consulta = toEntity(consultaRequestDTO);
        Consulta consultaSalvo = this.consultaRepository.save(consulta);
        return toDTO(consultaSalvo);
    }

    public ConsultaResponseDTO atualizarConsulta(Long id, ConsultaRequestDTO consultaRequestDTO){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Não existe consulta com esse id."));
        consulta.setDataHora(consultaRequestDTO.getDataHora());
        consulta.setMotivo(consultaRequestDTO.getMotivo());
        consulta.setValor(consultaRequestDTO.getValor());
        consulta.setPaciente(consultaRequestDTO.getPaciente());
        consulta.setMedico(consultaRequestDTO.getMedico());
        consulta.setConvenio(consultaRequestDTO.getConvenio());
        consulta.setReceita(consultaRequestDTO.getReceita());
        Consulta atualizado = consultaRepository.save(consulta);
        return toDTO(atualizado);
    }

    public String excluirConsulta(Long id){
        Consulta consulta = this.consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada"));
        this.consultaRepository.delete((consulta));
        return "Excluida com sucesso";
    }
}
