package com.api.hospital.dto;

import com.api.hospital.model.Convenio;
import com.api.hospital.model.Medico;
import com.api.hospital.model.Paciente;
import com.api.hospital.model.Receita;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ConsultaResponseDTO {
    private Long id;
    private Date dataHora;
    private String motivo;
    private double valor;
    private Paciente paciente;
    private Medico medico;
    private Convenio convenio;
    private Receita receita;
}
