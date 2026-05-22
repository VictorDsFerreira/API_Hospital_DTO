package com.api.hospital.config;

import com.api.hospital.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class HospitalConfiguration {

    @Bean
    public Prontuario getProntuario() {
        Prontuario prontuario = new Prontuario();
        prontuario.setTipoSanguineo("A+");
        prontuario.setAlergia("Alergia Teste");
        prontuario.setObservacoes("Paciente teste");

        return prontuario;
    }
    @Bean
    public Paciente getPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNome("Paciente Teste");
        paciente.setCpf("54584574584");
        paciente.setTelefone("15991884754");

        return paciente;
    }
    @Bean
    public Receita getReceita() {
        Receita receita = new Receita();
        receita.setMedicamento("Medicação Teste");
        receita.setDosagem("1g");
        receita.setDuracaoDias(10);

        return receita;
    }
    @Bean
    public Medico getMedico() {
        Medico medico = new Medico();
        medico.setNome("Medico Teste");
        medico.setEspecialidade("Especialidade Teste");
        medico.setCrm("11451");

        return medico;
    }
    @Bean
    public Convenio getConvenio() {
        Convenio convenio = new Convenio();
        convenio.setNome("Convenio Teste");
        convenio.setCnpj("5544884");

        return convenio;
    }
    @Bean
    public Consulta getConsulta() {
        Consulta consulta = new Consulta();
        consulta.setDataHora(LocalDateTime.of(2026, 6, 21, 15, 30, 0));
        consulta.setMotivo("Motivo Teste");
        consulta.setValor(4500.00);

        return consulta;
    }
}
