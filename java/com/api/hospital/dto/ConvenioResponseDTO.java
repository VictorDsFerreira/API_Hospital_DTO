package com.api.hospital.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvenioResponseDTO {
    private Long id;
    private String nome;
}
