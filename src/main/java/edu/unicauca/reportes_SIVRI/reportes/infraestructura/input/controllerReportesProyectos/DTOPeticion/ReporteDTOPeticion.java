package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReporteDTOPeticion {
    @NotNull(message = "{reporte.data.notnull}")
    private Object data;
    @NotBlank(message = "{reporte.tipoReporte.notblank}")
    private String tipoReporte;
    @NotBlank(message = "{reporte.formato.notblank}")
    private String formato;
}