package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteTipo1CDTOPeticion {

    // =========================================================
    // DATOS DEL GRUPO
    // =========================================================

    private String idGrupo;
    private String nombreGrupo;
    private String codigoGruplac;
    private String enlaceGruplac;

    /*
     * Estos campos pertenecen a la especificación del certificado.
     * La petición JSON de ejemplo actualmente no los envía.
     */
    private String directorGrupo;
    private String correoDirectorGrupo;
    private String correoGrupo;

    private String facultadGrupo;
    private String departamentoDirector;

    private String lineasInvestigacionGrupo;
    private String disciplinasGrupo;

    private String categorizacionGrupo;
    private String estadoGrupo;

    private String fechaCreacionGruplac;

    // =========================================================
    // DATOS DEL INTEGRANTE
    // =========================================================

    private String nombreIntegrante;
    private String numeroIdentificacion;

    private String estadoIntegranteGrupo;
    private String historialRolesEnGrupo;

    private String fechaInicioRol;
    private String fechaFinRol;

    private String facultadIntegrante;
    private String departamentoIntegrante;
    private String programaIntegrante;

    private String tipoVinculacionIntegrante;

    /*
     * Viene en el JSON real, aunque no hace parte
     * de los campos visibles del certificado.
     */
    private String enlaceCvlac;
}