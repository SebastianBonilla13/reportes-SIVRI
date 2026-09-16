package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion.ReporteTipo1CDTOPeticion;

@Component
public class ReporteTipo1CStrategy
        implements ReporteStrategy<ReporteTipo1CDTOPeticion> {

    private static final String Plantilla =
            "/reportes/R01-C.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipo1CDTOPeticion> datos) {

        Map<String, Object> parametrosLocales =
                new HashMap<>();

        if (datos != null && !datos.isEmpty()) {

            /*
             * Todos los registros corresponden al mismo grupo.
             * Se toma el primero para construir la información
             * general del certificado.
             */
            ReporteTipo1CDTOPeticion grupo = datos.get(0);

            parametrosLocales.put(
                    "idGrupo",
                    grupo.getIdGrupo()
            );

            parametrosLocales.put(
                    "nombreGrupo",
                    grupo.getNombreGrupo()
            );

            parametrosLocales.put(
                    "codigoGruplac",
                    grupo.getCodigoGruplac()
            );

            parametrosLocales.put(
                    "enlaceGruplac",
                    grupo.getEnlaceGruplac()
            );

            parametrosLocales.put(
                    "directorGrupo",
                    grupo.getDirectorGrupo()
            );

            parametrosLocales.put(
                    "correoDirectorGrupo",
                    grupo.getCorreoDirectorGrupo()
            );

            parametrosLocales.put(
                    "correoGrupo",
                    grupo.getCorreoGrupo()
            );

            parametrosLocales.put(
                    "facultadGrupo",
                    grupo.getFacultadGrupo()
            );

            parametrosLocales.put(
                    "departamentoDirector",
                    grupo.getDepartamentoDirector()
            );

            parametrosLocales.put(
                    "lineasInvestigacionGrupo",
                    grupo.getLineasInvestigacionGrupo()
            );

            parametrosLocales.put(
                    "disciplinasGrupo",
                    grupo.getDisciplinasGrupo()
            );

            parametrosLocales.put(
                    "categorizacionGrupo",
                    grupo.getCategorizacionGrupo()
            );

            parametrosLocales.put(
                    "estadoGrupo",
                    grupo.getEstadoGrupo()
            );

            parametrosLocales.put(
                    "fechaCreacionGruplac",
                    grupo.getFechaCreacionGruplac()
            );

            /*
             * IMPORTANTE:
             *
             * El JSON definitivo ya viene como una lista plana
             * de integrantes. Esa misma lista alimenta la tabla.
             */
            parametrosLocales.put(
                    "DATA_LIST",
                    datos
            );

        } else {

            parametrosLocales.put(
                    "DATA_LIST",
                    new ArrayList<>()
            );
        }

        parametrosLocales.put(
                "tituloReporte",
                "Certificados grupos de investigación e integrantes"
        );

        parametrosLocales.put(
                "codigoReporte",
                "R01-C"
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
    public TypeReference<List<ReporteTipo1CDTOPeticion>>
            getTypeReference() {

        return new TypeReference<List<ReporteTipo1CDTOPeticion>>() {
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
