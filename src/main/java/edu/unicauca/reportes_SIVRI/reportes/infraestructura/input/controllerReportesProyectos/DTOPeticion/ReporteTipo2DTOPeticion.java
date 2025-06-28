package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo2DTOPeticion {

    public ReporteTipo2DTOPeticion() {
    }

    private String nombre;
    private String identificacion;
    private String grupo;
    private String idGrupo;
    private String codigoGrupLAC;
    private String enlaceGrupLAC;
    private String historialRoles;
    private String estado;
    private String tipoVinculacion;
    private String facultad;
    private String departamento;
    private String programas;
    private String entidad;
}