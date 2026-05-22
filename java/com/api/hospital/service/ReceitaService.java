package com.api.hospital.service;

import com.api.hospital.dto.ReceitaRequestDTO;
import com.api.hospital.dto.ReceitaResponseDTO;
import com.api.hospital.dto.RegraNegocioException;
import com.api.hospital.model.Receita;
import com.api.hospital.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {
    private ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository){
        this.receitaRepository = receitaRepository;
    }

    private ReceitaResponseDTO toDTO(Receita receita){
        return ReceitaResponseDTO.builder()
                .id(receita.getId())
                .medicamento(receita.getMedicamento())
                .dosagem(receita.getDosagem())
                .duracaoDias(receita.getDuracaoDias())
                . build();
    }

    private Receita toEntity(ReceitaRequestDTO receitaRequestDTO){
        Receita receita = new Receita();
        receita.setMedicamento(receitaRequestDTO.getMedicamento());
        receita.setDosagem(receitaRequestDTO.getDosagem());
        receita.setDuracaoDias(receitaRequestDTO.getDuracaoDias());
        return receita;
    }

    public List<ReceitaResponseDTO> todasReceitas(){

        return this.receitaRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ReceitaResponseDTO receitaPorId(Long id){
        Receita receita = this.receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada."));
        return toDTO(receita);
    }

    public ReceitaResponseDTO salvarReceita(ReceitaRequestDTO receitaRequestDTO){
        Receita receita = toEntity(receitaRequestDTO);
        Receita receitaSalvo = this.receitaRepository.save(receita);
        return toDTO(receitaSalvo);
    }

    public ReceitaResponseDTO atualizarReceita(Long id, ReceitaRequestDTO receitaRequestDTO){
        Receita receita = receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Não existe receita com esse ID"));
        receita.setMedicamento(receitaRequestDTO.getMedicamento());
        receita.setDosagem(receitaRequestDTO.getDosagem());
        receita.setDuracaoDias(receitaRequestDTO.getDuracaoDias());
        Receita atualizado = receitaRepository.save(receita);
        return toDTO(atualizado);
    }

    public String excluirReceita(Long id){
        Receita receita = this.receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada"));
        this.receitaRepository.delete((receita));
        return "Excluida com sucesso";
    }
}
