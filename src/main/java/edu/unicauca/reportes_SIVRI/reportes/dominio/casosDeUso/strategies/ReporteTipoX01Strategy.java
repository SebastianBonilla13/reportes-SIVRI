package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion
        .ReporteTipoX01DTOPeticion;

@Component
public class ReporteTipoX01Strategy
        implements ReporteStrategy<ReporteTipoX01DTOPeticion> {

    private static final String Plantilla =
            "/reportes/X01.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipoX01DTOPeticion> datos) {

        Map<String, Object> parametros =
                new HashMap<>();

        parametros.put(
                "tituloReporte",
                "Presupuesto proyectos de Investigación"
        );

        parametros.put(
                "codigoReporte",
                "X01"
        );

        parametros.put(
                "versionReporte",
                "1.0"
        );

        String fechaActual = DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(java.time.LocalDate.now());

        parametros.put(
                "fechaReporte",
                fechaActual
        );

        /*
         * Por ahora X01 se maneja como un reporte plano.
         *
         * Cuando se defina el detalle por rubros,
         * se podrá modificar la estructura sin afectar
         * los primeros 10 campos ya establecidos.
         */
        parametros.put(
                "DATA_LIST",
                datos
        );

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipoX01DTOPeticion>>
            getTypeReference() {

        return new TypeReference<
                List<ReporteTipoX01DTOPeticion>>() {
        };
    }

    @Override
    public String getPlantilla() {
        return Plantilla;
    }

    @Override
    public Map<String, Object> getParametros() {
        return parametros;
    }
}