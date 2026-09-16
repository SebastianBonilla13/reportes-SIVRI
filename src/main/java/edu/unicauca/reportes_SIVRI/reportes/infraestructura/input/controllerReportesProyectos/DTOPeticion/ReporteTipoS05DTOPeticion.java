package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteTipoS05DTOPeticion {

    private String idProyecto;
    private String tituloProyecto;
    private String directorProyecto;
    private String estadoProyecto;

    private String fechaInicioProyecto;
    private String fechaFinProyecto;

    private String tipologiaProducto;
    private String categoriaProducto;

    private String nombreResponsableProducto;

    private String nombreSemillero;

    private String rolIntegranteResponsableProducto;

    private String nombreGrupoResponsableProducto;

    private String fechaVencimientoProducto;

    private String estadoProducto;

    private String tipoProyecto;

    /*
     * La tabla funcional dice nombreConvocatoria,
     * pero la petición definitiva utiliza
     * nombreConvocatoriaProyecto.
     */
    private String nombreConvocatoriaProyecto;

    private String elementoMisional;
}