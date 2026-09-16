package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteTipo2DTOPeticion {

    private String nombreIntegrante;
    private String numeroIdentificacion;

    private String nombreGrupo;
    private String idGrupo;

    private String codigoGruplac;
    private String enlaceGruplac;
    private String enlaceCvlac;

    private String historialRolesEnGrupo;

    private String fechaInicioRol;
    private String fechaFinRol;

    private String estadoIntegranteGrupo;

    private String tipoVinculacionIntegrante;

    private String facultadIntegrante;
    private String departamentoIntegrante;
    private String programaIntegrante;
}