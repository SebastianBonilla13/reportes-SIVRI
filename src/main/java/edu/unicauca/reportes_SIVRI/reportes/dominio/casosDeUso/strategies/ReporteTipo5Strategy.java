package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion
        .ReporteTipo5DTOPeticion;

@Component
public class ReporteTipo5Strategy
        implements ReporteStrategy<ReporteTipo5DTOPeticion> {

    private static final String Plantilla =
            "/reportes/R05.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipo5DTOPeticion> datos) {

        Map<String, Object> parametros =
                new HashMap<>();

        parametros.put(
                "tituloReporte",
                "Productos de Investigación - Compromisos proyectos"
        );

        parametros.put(
                "codigoReporte",
                "R05"
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
         * R05 es una lista plana.
         * Cada fila representa un producto/compromiso
         * asociado a un proyecto.
         */
        parametros.put(
                "DATA_LIST",
                datos
        );

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipo5DTOPeticion>>
            getTypeReference() {

        return new TypeReference<
                List<ReporteTipo5DTOPeticion>>() {
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