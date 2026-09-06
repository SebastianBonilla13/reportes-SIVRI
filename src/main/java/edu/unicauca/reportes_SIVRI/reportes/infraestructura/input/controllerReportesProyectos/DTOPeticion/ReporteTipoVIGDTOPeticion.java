package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReporteTipoVIGDTOPeticion {

    public ReporteTipoVIGDTOPeticion() {
    }

    private Long idProyecto;
    private String titulo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;
    private String director;
}
