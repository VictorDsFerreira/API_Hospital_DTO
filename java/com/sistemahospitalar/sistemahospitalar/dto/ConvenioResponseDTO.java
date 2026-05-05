package com.sistemahospitalar.sistemahospitalar.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvenioResponseDTO {
    private Long id;
    private String nome;
}
