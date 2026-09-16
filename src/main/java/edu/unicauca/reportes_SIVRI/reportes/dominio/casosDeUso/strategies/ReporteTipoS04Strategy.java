package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion
        .ReporteTipoS04DTOPeticion;

@Component
public class ReporteTipoS04Strategy
        implements ReporteStrategy<ReporteTipoS04DTOPeticion> {

    private static final String Plantilla =
            "/reportes/S04.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipoS04DTOPeticion> datos) {

        Map<String, Object> parametros =
                new HashMap<>();

        parametros.put(
                "tituloReporte",
                "Productos de Investigación - Compromisos Plan de trabajo del semillero"
        );

        parametros.put(
                "codigoReporte",
                "S04"
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
         * Petición plana:
         * cada registro corresponde a un producto/actividad
         * comprometido en un plan de trabajo.
         */
        parametros.put(
                "DATA_LIST",
                datos
        );

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipoS04DTOPeticion>>
            getTypeReference() {

        return new TypeReference<
                List<ReporteTipoS04DTOPeticion>>() {
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