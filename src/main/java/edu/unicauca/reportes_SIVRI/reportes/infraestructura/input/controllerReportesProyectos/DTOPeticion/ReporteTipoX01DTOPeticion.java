package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteTipoX01DTOPeticion {

    // =========================================================
    // INFORMACIÓN DEL PROYECTO
    // =========================================================

    private String idProyecto;
    private String tituloProyecto;
    private String directorProyecto;

    private String facultadProyecto;
    private String departamentoDirector;

    private String nombreGrupo;
    private String idGrupo;

    private String tipoProyecto;
    private String nombreConvocatoria;
    private String elementoMisional;

    // =========================================================
    // INFORMACIÓN PRESUPUESTAL
    // Estructura aún pendiente de definición
    // =========================================================

    private Object presupuestoAprobadoTotal;
    private Object presupuestoEjecutadoTotal;
    private Object presupuestoPorSolicitarTotal;
}
