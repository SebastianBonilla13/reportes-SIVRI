package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteTipoS02DTOPeticion {

    // =========================================================
    // CAMPOS DEL REPORTE S02
    // =========================================================

    private String nombreIntegrante;
    private String numeroIdentificacion;

    private String idSemillero;
    private String nombreSemillero;

    private String nombreGrupo;
    private String idGrupo;

    private String enlaceCvlac;

    private String historialRolesEnSemillero;

    private String fechaInicioRol;
    private String fechaFinRol;

    private String estadoIntegranteSemillero;

    private String tipoVinculacionIntegrante;

    private String facultadIntegrante;
    private String departamentoIntegrante;
    private String programaIntegrante;

    // =========================================================
    // CAMPOS QUE VIENEN EN LA PETICIÓN PERO NO SE VISUALIZAN
    // EN ESTE REPORTE
    // =========================================================

    private String facultadSemillero;
    private String departamentoSemillero;
    private String fechaCreacionSemillero;
}