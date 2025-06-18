package edu.unicauca.reportes_SIVRI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProyectoDTO {
    private Long idProyecto;
    private String titulo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;
    private String director;

    private String estado; // varios
    private List<String> gruposInvestigacion;
    private List<String> facultades;
    private List<String> departamentos;
    private String tipoProyecto; // "interno" o "externo"
    private String nombreConvocatoria;
    private String divisionVRI;
    private String lugarEjecucion;

}