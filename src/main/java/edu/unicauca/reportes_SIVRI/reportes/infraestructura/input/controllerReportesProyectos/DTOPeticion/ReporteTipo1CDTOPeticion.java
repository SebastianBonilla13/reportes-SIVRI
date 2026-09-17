package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
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
    // DATOS GENERALES DEL GRUPO
    // =========================================================

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
    private String categorizacionGrupo;
    private String disciplinasGrupo;

    private String estadoGrupo;
    private String fechaCreacionGruplac;

    // =========================================================
    // LISTA DE INTEGRANTES
    // =========================================================

    /*
     * El front envía esta lista con el nombre "DataIntegrantes".
     * Internamente se mantiene el nombre Java "integrantes".
     */
    @JsonAlias("DataIntegrantes")
    private List<IntegranteDTO> integrantes;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IntegranteDTO {

        private String numeroIdentificacion;
        private String nombreIntegrante;

        private String fechaInicioRol;
        private String fechaFinRol;

        private String idGrupo;
        private String nombreGrupo;

        private String historialRolesEnGrupo;
        private String estadoIntegranteGrupo;

        private String codigoGruplac;
        private String enlaceGruplac;
        private String enlaceCvlac;

        private String tipoVinculacionIntegrante;
        private String facultadIntegrante;
        private String departamentoIntegrante;
        private String programaIntegrante;
    }
}