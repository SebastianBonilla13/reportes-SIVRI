package edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteTipo8DTOPeticion {

    public ReporteTipo8DTOPeticion() {
    }

    private String idProyecto;
    private String tituloProyecto;
    private String directorProyecto;
    private String estadoProyecto;

    private String fechaInicioProyecto;
    private String fechaFinProyecto;

    private String tipologiaProducto;
    private String categoriaProducto;
    private String nombreResponsableProducto;
    private String grupoInvestigacionResponsable;
    private String estadoProducto;

    private String tipoProyecto;
    private String nombreConvocatoria;
    private String elementoMisional;
}