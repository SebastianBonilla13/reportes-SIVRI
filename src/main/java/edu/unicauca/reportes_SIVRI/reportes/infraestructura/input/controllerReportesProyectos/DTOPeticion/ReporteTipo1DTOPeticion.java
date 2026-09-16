package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    private String departamentoDirector;

    private String lineasInvestigacionGrupo;
    private String disciplinasGrupo;

    private String categorizacionGrupo;
    private String estadoGrupo;

    /*
     * Viene en la petición definitiva del front,
     * aunque actualmente no es una columna de R01.
     */
    private String fechaCreacionGruplac;
}