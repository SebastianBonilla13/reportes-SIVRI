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
        .ReporteTipo1CDTOPeticion;

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
             * R01-C recibe un arreglo cuyo primer elemento contiene:
             *
             * 1. La información general del grupo.
             * 2. La lista anidada "integrantes".
             *
             * La información general alimenta los parámetros del JRXML.
             * La lista de integrantes alimenta directamente DATA_LIST.
             */
            ReporteTipo1CDTOPeticion grupo = datos.get(0);

            // =====================================================
            // INFORMACIÓN GENERAL DEL GRUPO
            // =====================================================

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

            // =====================================================
            // TABLA DE INTEGRANTES
            // =====================================================

            /*
             * JasperHelper crea el JRBeanCollectionDataSource a partir
             * de DATA_LIST. Por eso aquí debe ir la lista anidada de
             * integrantes y NO el objeto general del grupo.
             */
            parametrosLocales.put(
                    "DATA_LIST",
                    grupo.getIntegrantes() != null
                            ? grupo.getIntegrantes()
                            : new ArrayList<>()
            );

        } else {

            parametrosLocales.put(
                    "DATA_LIST",
                    new ArrayList<>()
            );
        }

        // =========================================================
        // DATOS DEL REPORTE
        // =========================================================

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

        return new TypeReference<
                List<ReporteTipo1CDTOPeticion>>() {
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