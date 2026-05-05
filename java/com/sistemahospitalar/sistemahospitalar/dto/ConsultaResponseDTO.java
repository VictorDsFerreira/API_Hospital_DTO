package com.sistemahospitalar.sistemahospitalar.dto;

import com.sistemahospitalar.sistemahospitalar.model.Convenio;
import com.sistemahospitalar.sistemahospitalar.model.Medico;
import com.sistemahospitalar.sistemahospitalar.model.Paciente;
import com.sistemahospitalar.sistemahospitalar.model.Receita;
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
