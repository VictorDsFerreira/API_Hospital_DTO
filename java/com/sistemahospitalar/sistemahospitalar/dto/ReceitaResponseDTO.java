package com.sistemahospitalar.sistemahospitalar.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceitaResponseDTO {
    private Long id;
    private String medicamento;
    private String dosagem;
    private int duracaoDias;
}
