package com.sistemahospitalar.sistemahospitalar.service;

import com.sistemahospitalar.sistemahospitalar.dto.ProntuarioRequestDTO;
import com.sistemahospitalar.sistemahospitalar.dto.ProntuarioResponseDTO;
import com.sistemahospitalar.sistemahospitalar.model.Prontuario;
import com.sistemahospitalar.sistemahospitalar.model.Prontuario;
import com.sistemahospitalar.sistemahospitalar.model.Prontuario;
import com.sistemahospitalar.sistemahospitalar.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {
    private ProntuarioRepository prontuarioRepository;

    public ProntuarioService(ProntuarioRepository prontuarioRepository){
        this.prontuarioRepository = prontuarioRepository;
    }

    private ProntuarioResponseDTO toDTO(Prontuario prontuario){
        return ProntuarioResponseDTO.builder()
                .id(prontuario.getId())
                .tipoSanguineo(prontuario.getTipoSanguineo())
                .alergia(prontuario.getAlergia())
                .observações(prontuario.getObservações())
                . build();
    }

    private Prontuario toEntity(ProntuarioRequestDTO prontuarioRequestDTO){
        Prontuario prontuario = new Prontuario();
        prontuario.setTipoSanguineo(prontuarioRequestDTO.getTipoSanguineo());
        prontuario.setAlergia(prontuarioRequestDTO.getAlergia());
        prontuario.setObservações(prontuarioRequestDTO.getObservações());
        return prontuario;
    }

    public List<ProntuarioResponseDTO> todosProntuarios(){

        return this.prontuarioRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ProntuarioResponseDTO prontuarioPorId(Long id){
        Prontuario prontuario = this.prontuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuario não encontrado."));
        return toDTO(prontuario);
    }

    public ProntuarioResponseDTO salvarProntuario(ProntuarioRequestDTO prontuarioRequestDTO){
        Prontuario prontuario = toEntity(prontuarioRequestDTO);
        Prontuario prontuarioSalvo = this.prontuarioRepository.save(prontuario);
        return toDTO(prontuarioSalvo);
    }

    public ProntuarioResponseDTO atualizarProntuario(Long id, ProntuarioRequestDTO prontuarioRequestDTO){
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuario não encontrado"));
        prontuario.setTipoSanguineo(prontuarioRequestDTO.getTipoSanguineo());
        prontuario.setAlergia(prontuarioRequestDTO.getAlergia());
        prontuario.setObservações(prontuarioRequestDTO.getObservações());
        Prontuario atualizado = prontuarioRepository.save(prontuario);
        return toDTO(atualizado);
    }

    public String excluirProntuario(Long id){
        Prontuario prontuario = this.prontuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuario não encontrado"));
        this.prontuarioRepository.delete((prontuario));
        return "Excluido com sucesso";
    }
}
