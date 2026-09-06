package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo2DTOPeticion {

    public ReporteTipo2DTOPeticion() {
    }

    private String idGrupo;
    private String nombreGrupo;
    private String codigoGruplac;
    private String enlaceGruplac;
    private String directorGrupo;
    private String correoDirectorGrupo;
    private String correoGrupo;
    private String lineasInvestigacionGrupo;
    private String categorizacionGrupo;
    private String disciplinasGrupo;
}