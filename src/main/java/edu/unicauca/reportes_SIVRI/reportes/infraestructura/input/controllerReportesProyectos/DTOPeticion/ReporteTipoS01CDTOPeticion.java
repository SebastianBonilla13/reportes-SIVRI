package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteTipoS01CDTOPeticion {

    // =========================================================
    // INFORMACIÓN GENERAL DEL SEMILLERO
    // Campos 1 - 7
    // =========================================================

    private String idSemillero;
    private String nombreSemillero;

    private String idGrupo;
    private String nombreGrupo;

    private String facultadSemillero;
    private String departamentoSemillero;

    private String fechaCreacionSemillero;

    // =========================================================
    // INFORMACIÓN DEL INTEGRANTE
    // Campos grises 8 - 16
    // =========================================================

    private String nombreIntegrante;
    private String numeroIdentificacion;

    private String historialRolesEnSemillero;

    private String fechaInicioRol;
    private String fechaFinRol;

    private String estadoIntegranteSemillero;

    private String tipoVinculacionIntegrante;

    private String facultadIntegrante;
    private String departamentoIntegrante;

    /*
     * Viene en el JSON y sirve para estudiantes,
     * aunque la tabla funcional agrupa departamento/programa
     * dentro del campo 16.
     */
    private String programaIntegrante;

    /*
     * Viene en la petición real, pero no hace parte
     * de los campos visibles solicitados para S01-C.
     */
    private String enlaceCvlac;
}