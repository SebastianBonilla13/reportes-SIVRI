package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo3DTOPeticion {

    public ReporteTipo3DTOPeticion() {
    }

    private String idGrupo;
    private String nombreGrupo;
    private String codigoGruplac;
    private String facultadGrupo;
    private String departamentoDirector;
    private String estadoIntegranteGrupo;
    private String categorizacionGrupo;
}
