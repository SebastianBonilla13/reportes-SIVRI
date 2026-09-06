package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion.ReporteTipo3DTOPeticion;

@Component
public class ReporteTipo3Strategy
        implements ReporteStrategy<ReporteTipo3DTOPeticion> {

    private static final String Plantilla = "/reportes/R03.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipo3DTOPeticion> datos) {

        Map<String, Object> parametros = new HashMap<>();

        parametros.put(
                "tituloReporte",
                "Categorización Grupos de investigación"
        );

        parametros.put("codigoReporte", "R03");
        parametros.put("versionReporte", "1.0");

        String fechaActual = DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(java.time.LocalDate.now());

        parametros.put("fechaReporte", fechaActual);

        parametros.put("DATA_LIST", datos);

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipo3DTOPeticion>>
            getTypeReference() {

        return new TypeReference<List<ReporteTipo3DTOPeticion>>() {
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