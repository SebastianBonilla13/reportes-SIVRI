package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo7DTOPeticion {

    public ReporteTipo7DTOPeticion() {
    }

    private String idProyecto;
    private String tituloProyecto;
    private String estadoProyecto;
    private String fechaInicioProyecto;
    private String fechaFinProyecto;

    private String nombreIntegrante;
    private String historialRolesEnProyecto;
    private String fechasVinculacionRol;

    private List<String> grupoInvestigacionVinculado;
    private List<String> semilleroInvestigacionVinculado;

    private String facultadIntegrante;
    private String departamentoIntegrante;
    private String programaIntegrante;

    private String tipoProyecto;
    private String nombreConvocatoria;
    private String elementoMisional;

    private String horasDedicacionSemanal;
}