package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo6DTOPeticion {

    public ReporteTipo6DTOPeticion() {
    }

    private String idProyecto;
    private String tituloProyecto;
    private String estadoProyecto;
    private String fechaInicioProyecto;
    private String fechaFinProyecto;
    private String directorProyecto;
    private List<String> gruposInvestigacion;
    private String facultadesProyecto;
    private String departamentoDirector;
    private String tipoProyecto;
    private String nombreConvocatoria;
    private String elementoMisional;
    private String palabrasClaves;
}