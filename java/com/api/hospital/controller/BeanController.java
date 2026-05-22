package com.api.hospital.controller;

import com.api.hospital.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("bean")
public class BeanController {

    @Autowired
    private Prontuario prontuarioPadrao;

    @Autowired
    private Paciente pacientePadrao;

    @Autowired
    private Receita receitaPadrao;

    @Autowired
    private Medico medicoPadrao;

    @Autowired
    private Convenio convenioPadrao;

    @Autowired
    private Consulta consultaPadrao;

    @GetMapping
    public Consulta getConsulta() {
        pacientePadrao.setProntuario(prontuarioPadrao);
        List<Consulta> consultas = new ArrayList<>();
        consultas.add(consultaPadrao);
        consultaPadrao.setPaciente(pacientePadrao);
        consultaPadrao.setMedico(medicoPadrao);
        consultaPadrao.setConvenio(convenioPadrao);
        consultaPadrao.setReceita(receitaPadrao);

        return consultaPadrao;
    }
}
