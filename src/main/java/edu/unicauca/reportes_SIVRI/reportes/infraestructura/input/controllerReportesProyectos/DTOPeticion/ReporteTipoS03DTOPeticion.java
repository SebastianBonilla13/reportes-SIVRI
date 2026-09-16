package edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteTipoS03DTOPeticion {

    private String idProyecto;
    private String tituloProyecto;
    private String estadoProyecto;

    private String fechaInicioProyecto;
    private String fechaFinProyecto;

    private String directorProyecto;

    private String nombreGrupo;

    private String facultadProyecto;
    private String departamentoDocente;

    private String nombreSemillero;

    private String tipoProyecto;
    private String nombreConvocatoria;

    private String elementoMisional;

    private Integer horasDedicacionSemanal;
}