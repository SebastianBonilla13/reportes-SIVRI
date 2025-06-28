package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReporteDTOPeticion {
    private Object data; // Puede ser un DTO específico
    private String tipoReporte; //Referencia tipo reporte
    private String formato; // PDF, csv, docx, etc.
}