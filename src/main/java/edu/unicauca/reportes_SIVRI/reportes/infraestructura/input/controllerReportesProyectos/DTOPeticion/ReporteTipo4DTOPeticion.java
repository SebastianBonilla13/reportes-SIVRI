package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo4DTOPeticion {

    public ReporteTipo4DTOPeticion() {
    }

    private String nombreCompletoDeIntegrante;
    private String numeroIdentificacion;
    private String nombreGrupoDeInvestigacion;
    private String idGrupo;
    private String codigoGruplac;
    private String enlaceGruplac;
    private String enlaceCvlac;
    private String historialRolesEnGrupo;
    private String fechaInicioRol;
    private String fechaFinRol;
    private String estadoGrupo;
    private String tipoVinculacion;
    private String facultad;
    private String departamento;
    private String programa;
}
