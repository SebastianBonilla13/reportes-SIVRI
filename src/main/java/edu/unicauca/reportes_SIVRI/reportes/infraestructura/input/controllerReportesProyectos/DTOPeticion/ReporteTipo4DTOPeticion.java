package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteTipo4DTOPeticion {

    private String numeroIdentificacion;
    private String nombreIntegrante;

    private String tituloProyecto;
    private String idProyecto;
    private String tipoProyecto;

    private String fechaInicioProyecto;
    private String fechaFinProyecto;
    private String estadoProyecto;

    private String fechaVinculacionRol;
    private String historialRolesEnProyecto;

    private String grupoInvestigacionVinculado;
    private String semilleroInvestigacionVinculado;

    private String nombreConvocatoria;
    private String elementoMisional;

    private Integer horasDedicacionSemanal;

    private String facultadIntegrante;
    private String departamentoIntegrante;
    private String programaIntegrante;
}
