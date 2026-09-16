package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion
        .ReporteTipoS02DTOPeticion;

@Component
public class ReporteTipoS02Strategy
        implements ReporteStrategy<ReporteTipoS02DTOPeticion> {

    private static final String Plantilla =
            "/reportes/S02.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipoS02DTOPeticion> datos) {

        Map<String, Object> parametros =
                new HashMap<>();

        parametros.put(
                "tituloReporte",
                "Integrantes Semilleros de Investigación"
        );

        parametros.put(
                "codigoReporte",
                "S02"
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

        parametros.put(
                "DATA_LIST",
                datos
        );

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipoS02DTOPeticion>>
            getTypeReference() {

        return new TypeReference<
                List<ReporteTipoS02DTOPeticion>>() {
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