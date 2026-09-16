package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteTipoS04DTOPeticion {

    private String idPlanTrabajo;

    private String estadoSemillero;

    private String nombreActividadPlanTrabajo;
    private String objetivoActividadPlanTrabajo;

    private String fechaInicioActividadPlanTrabajo;
    private String fechaFinActividadPlanTrabajo;

    private String estadoProducto;

    private String tipologiaProducto;
    private String categoriaProducto;

    private String nombreResponsableProducto;
    private String nombreGrupoResponsableProducto;
}