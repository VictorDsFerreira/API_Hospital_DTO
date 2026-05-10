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
public class PacienteRequestDTO {
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;
    @NotBlank(message = "CPF é obrigatório!")
    private String cpf;
    @NotBlank(message = "Telefone é obrigatório!")
    private String telefone;
}
