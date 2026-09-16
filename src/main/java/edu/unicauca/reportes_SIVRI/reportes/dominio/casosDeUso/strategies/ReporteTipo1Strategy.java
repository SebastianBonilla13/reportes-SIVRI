package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion.ReporteTipo1DTOPeticion;

@Component
public class ReporteTipo1Strategy
        implements ReporteStrategy<ReporteTipo1DTOPeticion> {

    private static final String Plantilla = "/reportes/R01.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipo1DTOPeticion> datos) {

        Map<String, Object> parametros = new HashMap<>();

        parametros.put(
                "tituloReporte",
                "Grupos de Investigación"
        );

        parametros.put("codigoReporte", "R01");
        parametros.put("versionReporte", "1.0");

        String fechaActual = DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(java.time.LocalDate.now());

        parametros.put("fechaReporte", fechaActual);

        /*
         * Para R01 la lista recibida desde el front
         * es directamente la fuente de datos de Jasper.
         */
        parametros.put("DATA_LIST", datos);

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipo1DTOPeticion>>
            getTypeReference() {

        return new TypeReference<List<ReporteTipo1DTOPeticion>>() {
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