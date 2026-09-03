package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Data
@AllArgsConstructor
public class ReporteTipo1DTOPeticion {

    public ReporteTipo1DTOPeticion() {
    }

    private String idGrupo;
    private String nombreGrupo;
    private String codigoGruplac;
    private String enlaceGruplac;
    private String directorGrupo;
    private String correoDirectorGrupo;
    private String correoGrupo;
    private String facultadGrupo;
    private String lineasInvestigacionGrupo;
    private String categorizacionGrupo;
    private String disciplinasGrupo;
}