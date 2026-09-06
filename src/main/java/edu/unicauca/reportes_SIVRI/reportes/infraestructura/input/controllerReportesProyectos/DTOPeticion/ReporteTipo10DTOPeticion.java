package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo10DTOPeticion {

    public ReporteTipo10DTOPeticion() {
    }

    private String nombreGrupo;
    private String idGrupo;
    private String codigoGruplac;
    private String fechaCreacionGruplac;

    private String facultadGrupo;
    private String departamentoGrupo;

    private String nombreIntegrante;
    private String numeroIdentificacion;
    private String estadoVinculacion;

    private String historialRolesEnGrupo;
    private String fechaInicioRol;
    private String fechaFinRol;

    private String facultadIntegrante;
    private String departamentoIntegrante;
    private String programaIntegrante;

    private String tipoVinculacionIntegrante;
}