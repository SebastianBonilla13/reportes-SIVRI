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
public class ReporteTipo4CDTOPeticion {

    // =========================================================
    // INFORMACIÓN GENERAL DEL INTEGRANTE
    // =========================================================

    private String nombreIntegrante;
    private String numeroIdentificacion;

    private String facultadIntegrante;
    private String departamentoIntegrante;
    private String programaIntegrante;

    // =========================================================
    // PROYECTOS DEL INTEGRANTE
    // =========================================================

    private List<ProyectoDTO> proyectos;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProyectoDTO {

        private String idProyecto;
        private String tituloProyecto;

        private String fechaInicioProyecto;
        private String fechaFinProyecto;

        private String historialRolesEnProyecto;

        private String fechaInicioRolProyecto;
        private String fechaFinRolProyecto;

        private String nombreGrupo;
        private String idGrupo;
        private String codigoGruplac;

        private String nombreSemillero;
        private String idSemillero;

        private Integer horasDedicacionSemanal;

        private String tipoProyecto;
        private String nombreConvocatoria;

        private String elementoMisional;
    }
}