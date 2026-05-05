package com.sistemahospitalar.sistemahospitalar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConvenioRequestDTO {
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;
    @NotBlank(message = "CNPJ é obrigatório!")
    private String cnpj;
}
