package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteTipo4DTOPeticion;

@Component
public class ReporteTipo4Strategy implements ReporteStrategy<ReporteTipo4DTOPeticion> {

    private static final String Plantilla = "/reportes/R04.jrxml";
    private static final Map<String, Object> parametros = new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(List<ReporteTipo4DTOPeticion> datos) {

        Map<String, Object> parametros = new HashMap<>();

        parametros.put(
            "tituloReporte",
            "Integrantes Grupos de Investigación Universidad del Cauca"
        );

        parametros.put("codigoReporte", "R04");

        // La ficha suministrada no especifica versión.
        // Se deja 1.0 como valor inicial.
        parametros.put("versionReporte", "1.0");

        String fechaActual = DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(java.time.LocalDate.now());

        parametros.put("fechaReporte", fechaActual);

        parametros.put("DATA_LIST", datos);

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipo4DTOPeticion>> getTypeReference() {

        return new TypeReference<List<ReporteTipo4DTOPeticion>>() {
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
