package com.api.hospital.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaRequestDTO {
    @NotBlank(message = "Medicamento é obrigatório!")
    private String medicamento;
    @NotBlank(message = "Dosagem é obrigatória!")
    private String dosagem;
    @NotBlank(message = "Duração de dias é obrigatória!")
    private int duracaoDias;
}
