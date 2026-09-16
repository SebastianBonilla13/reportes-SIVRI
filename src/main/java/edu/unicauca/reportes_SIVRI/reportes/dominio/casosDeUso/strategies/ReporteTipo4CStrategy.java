package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion
        .ReporteTipo4CDTOPeticion;

@Component
public class ReporteTipo4CStrategy
        implements ReporteStrategy<ReporteTipo4CDTOPeticion> {

    private static final String Plantilla =
            "/reportes/R04-C.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipo4CDTOPeticion> datos) {

        Map<String, Object> parametrosLocales =
                new HashMap<>();

        if (datos != null && !datos.isEmpty()) {

            ReporteTipo4CDTOPeticion integrante =
                    datos.get(0);

            // =====================================================
            // INFORMACIÓN GENERAL DEL INTEGRANTE
            // =====================================================

            parametrosLocales.put(
                    "nombreIntegrante",
                    integrante.getNombreIntegrante()
            );

            parametrosLocales.put(
                    "numeroIdentificacion",
                    integrante.getNumeroIdentificacion()
            );

            parametrosLocales.put(
                    "facultadIntegrante",
                    integrante.getFacultadIntegrante()
            );

            parametrosLocales.put(
                    "departamentoIntegrante",
                    integrante.getDepartamentoIntegrante()
            );

            parametrosLocales.put(
                    "programaIntegrante",
                    integrante.getProgramaIntegrante()
            );

            // =====================================================
            // PROYECTOS
            // =====================================================

            if (integrante.getProyectos() != null) {

                parametrosLocales.put(
                        "DATA_LIST",
                        integrante.getProyectos()
                );

            } else {

                parametrosLocales.put(
                        "DATA_LIST",
                        new ArrayList<>()
                );
            }

        } else {

            parametrosLocales.put(
                    "DATA_LIST",
                    new ArrayList<>()
            );
        }

        // =========================================================
        // METADATOS DEL REPORTE
        // =========================================================

        parametrosLocales.put(
                "tituloReporte",
                "Certificados integrantes proyectos de investigación"
        );

        parametrosLocales.put(
                "codigoReporte",
                "R04-C"
        );

        parametrosLocales.put(
                "versionReporte",
                "1.0"
        );

        String fechaActual = DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(java.time.LocalDate.now());

        parametrosLocales.put(
                "fechaReporte",
                fechaActual
        );

        return parametrosLocales;
    }

    @Override
    public TypeReference<List<ReporteTipo4CDTOPeticion>>
            getTypeReference() {

        return new TypeReference<
                List<ReporteTipo4CDTOPeticion>>() {
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