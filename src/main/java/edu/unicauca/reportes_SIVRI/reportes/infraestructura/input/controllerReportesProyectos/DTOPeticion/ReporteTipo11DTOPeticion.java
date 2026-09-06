package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo11DTOPeticion {

    public ReporteTipo11DTOPeticion() {
    }

    private String nombreIntegrante;
    private String numeroIdentificacion;

    private String facultadIntegrante;
    private String departamentoIntegrante;
    private String programaIntegrante;

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

    private String horasDedicacionSemanal;

    private String tipoProyecto;
    private String nombreConvocatoria;
    private String elementoMisional;
}