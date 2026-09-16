package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion
        .ReporteTipoS03DTOPeticion;

@Component
public class ReporteTipoS03Strategy
        implements ReporteStrategy<ReporteTipoS03DTOPeticion> {

    private static final String Plantilla =
            "/reportes/S03.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipoS03DTOPeticion> datos) {

        Map<String, Object> parametros =
                new HashMap<>();

        parametros.put(
                "tituloReporte",
                "Proyectos Semilleros de Investigación"
        );

        parametros.put(
                "codigoReporte",
                "S03"
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
         * S03 es una petición plana.
         * Cada elemento representa un proyecto
         * asociado a un semillero.
         */
        parametros.put(
                "DATA_LIST",
                datos
        );

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipoS03DTOPeticion>>
            getTypeReference() {

        return new TypeReference<
                List<ReporteTipoS03DTOPeticion>>() {
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