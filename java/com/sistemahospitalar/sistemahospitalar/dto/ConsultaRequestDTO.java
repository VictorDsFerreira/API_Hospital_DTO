package com.sistemahospitalar.sistemahospitalar.dto;

import com.sistemahospitalar.sistemahospitalar.model.Convenio;
import com.sistemahospitalar.sistemahospitalar.model.Medico;
import com.sistemahospitalar.sistemahospitalar.model.Paciente;
import com.sistemahospitalar.sistemahospitalar.model.Receita;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaRequestDTO {
    @NotBlank(message = "Data é obrigatória!")
    private Date dataHora;
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
