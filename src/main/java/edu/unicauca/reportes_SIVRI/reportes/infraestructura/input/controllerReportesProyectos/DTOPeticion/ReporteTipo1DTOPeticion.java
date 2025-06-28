package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ReporteTipo1DTOPeticion {

    public ReporteTipo1DTOPeticion() {
    }
    // Realizar Validaciones en el DTO

    private Long idProyecto;
    private String titulo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;
    private String director;

    /* private String estado;
    private List<String> gruposInvestigacion;
    private List<String> facultades;
    private List<String> departamentos;
    private String tipoProyecto;
    private String nombreConvocatoria;
    private String divisionVRI;
    private String lugarEjecucion; */
}




    

