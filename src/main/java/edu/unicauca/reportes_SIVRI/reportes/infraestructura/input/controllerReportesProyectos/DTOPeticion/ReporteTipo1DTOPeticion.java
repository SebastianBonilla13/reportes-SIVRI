package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReporteTipo1DTOPeticion {

    public ReporteTipo1DTOPeticion() {
    }

    private String idSemillero;
    private String nombreSemilleroInvestigacion;
    private String mentorSemillero;
    private String coordinadorSemillero;
    private String correoMentorSemillero;
    private String correoSemilleroInvestigacion;
    private String facultad;
    private String programa;
    private String departamento;
    private String lineasInvestigacion;
    private String objetivoSemillero;
    private String disciplina;
    private String fechaInicio;
    private String fechaFin;
}