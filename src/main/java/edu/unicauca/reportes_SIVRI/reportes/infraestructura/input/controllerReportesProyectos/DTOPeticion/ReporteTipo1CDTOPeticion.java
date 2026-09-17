package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import java.util.List;

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
    private String disciplinasGrupo;

    private String categorizacionGrupo;
    private String estadoGrupo;
    private String fechaCreacionGruplac;

    // =========================================================
    // LISTA DE INTEGRANTES
    // =========================================================

    private List<IntegranteDTO> integrantes;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IntegranteDTO {

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
         * El front también puede enviarlo.
         * Actualmente no se imprime en el certificado,
         * pero se conserva en el DTO para representar
         * correctamente la estructura recibida.
         */
        private String enlaceCvlac;
    }
}