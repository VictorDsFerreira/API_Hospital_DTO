package com.api.hospital.dto;

import com.api.hospital.model.Convenio;
import com.api.hospital.model.Medico;
import com.api.hospital.model.Paciente;
import com.api.hospital.model.Receita;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaRequestDTO {
    @NotBlank(message = "Data é obrigatória!")
    private LocalDateTime dataHora;
    @NotBlank(message = "Motivo é obrigatório!")
    private String motivo;
    @NotBlank(message = "Valor é obrigatório!")
    private double valor;
    @NotBlank(message = "Paciente é obrigatóriao!")
    private Paciente paciente;
    @NotBlank(message = "Medico é obrigatório!")
    private Medico medico;
    @NotBlank(message = "Convenio é obrigatório!")
    private Convenio convenio;
    @NotBlank(message = "Receita é obrigatória!")
    private Receita receita;
}
