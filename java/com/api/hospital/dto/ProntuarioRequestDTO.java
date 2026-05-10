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
public class ProntuarioRequestDTO {
    @NotBlank(message = "Tipo Sanguineo é obrigatório!")
    private String tipoSanguineo;
    private String alergia;
    private String observações;
}
