package com.api.hospital.service;

import com.api.hospital.dto.ConvenioRequestDTO;
import com.api.hospital.dto.ConvenioResponseDTO;
import com.api.hospital.dto.RegraNegocioException;
import com.api.hospital.model.Convenio;
import com.api.hospital.repository.ConvenioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenioService {
    private ConvenioRepository convenioRepository;

    public ConvenioService(ConvenioRepository convenioRepository){
        this.convenioRepository = convenioRepository;
    }

    private ConvenioResponseDTO toDTO(Convenio convenio){
        return ConvenioResponseDTO.builder()
                .id(convenio.getId())
                .nome(convenio.getNome())
                . build();
    }

    private Convenio toEntity(ConvenioRequestDTO convenioRequestDTO){
        Convenio convenio = new Convenio();
        convenio.setNome(convenioRequestDTO.getNome());
        convenio.setCnpj(convenioRequestDTO.getCnpj());
        return convenio;
    }

    public List<ConvenioResponseDTO> todosConvenios(){

        return this.convenioRepository.findAll()
                .stream()
                .map(this :: toDTO)
                .toList();
    }

    public ConvenioResponseDTO convenioPorId(Long id){
        Convenio convenio = this.convenioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convenio não encontrado."));
        return toDTO(convenio);
    }

    public ConvenioResponseDTO salvarConvenio(ConvenioRequestDTO convenioRequestDTO){
        Convenio convenio = toEntity(convenioRequestDTO);
        Convenio convenioSalvo = this.convenioRepository.save(convenio);
        return toDTO(convenioSalvo);
    }

    public ConvenioResponseDTO atualizarConvenio(Long id, ConvenioRequestDTO convenioRequestDTO){
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Não existe convenio com esse id."));
        convenio.setNome(convenioRequestDTO.getNome());
        convenio.setCnpj(convenioRequestDTO.getCnpj());
        Convenio atualizado = convenioRepository.save(convenio);
        return toDTO(atualizado);
    }

    public String excluirConvenio(Long id){
        Convenio convenio = this.convenioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convenio não encontrado"));
        this.convenioRepository.delete((convenio));
        return "Excluido com sucesso";
    }
}
