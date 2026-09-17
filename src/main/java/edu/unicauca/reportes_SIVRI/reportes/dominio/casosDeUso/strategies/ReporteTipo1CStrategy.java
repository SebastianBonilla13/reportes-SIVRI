package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.LocalDate;
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
             * El front envía data como una lista.
             * Para R01-C se espera un único objeto raíz de grupo
             * que contiene la lista anidada DataIntegrantes.
             */
            ReporteTipo1CDTOPeticion grupo = datos.get(0);

            // =====================================================
            // INFORMACIÓN GENERAL DEL GRUPO
            // =====================================================

            parametrosLocales.put("idGrupo", grupo.getIdGrupo());
            parametrosLocales.put("nombreGrupo", grupo.getNombreGrupo());
            parametrosLocales.put("codigoGruplac", grupo.getCodigoGruplac());
            parametrosLocales.put("enlaceGruplac", grupo.getEnlaceGruplac());

            parametrosLocales.put("directorGrupo", grupo.getDirectorGrupo());
            parametrosLocales.put(
                    "correoDirectorGrupo",
                    grupo.getCorreoDirectorGrupo()
            );
            parametrosLocales.put("correoGrupo", grupo.getCorreoGrupo());

            parametrosLocales.put("facultadGrupo", grupo.getFacultadGrupo());
            parametrosLocales.put(
                    "departamentoDirector",
                    grupo.getDepartamentoDirector()
            );

            parametrosLocales.put(
                    "lineasInvestigacionGrupo",
                    grupo.getLineasInvestigacionGrupo()
            );
            parametrosLocales.put(
                    "categorizacionGrupo",
                    grupo.getCategorizacionGrupo()
            );
            parametrosLocales.put(
                    "disciplinasGrupo",
                    grupo.getDisciplinasGrupo()
            );

            parametrosLocales.put("estadoGrupo", grupo.getEstadoGrupo());
            parametrosLocales.put(
                    "fechaCreacionGruplac",
                    grupo.getFechaCreacionGruplac()
            );

            // =====================================================
            // TABLA DE INTEGRANTES
            // =====================================================

            /*
             * JasperHelper toma DATA_LIST y crea con ella el
             * JRBeanCollectionDataSource.
             *
             * Por eso DATA_LIST debe contener la lista de integrantes,
             * no el objeto raíz del grupo.
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
        // DATOS FIJOS DEL REPORTE
        // =========================================================

        parametrosLocales.put(
                "tituloReporte",
                "Certificados grupos de investigación e integrantes"
        );

        parametrosLocales.put("codigoReporte", "R01-C");
        parametrosLocales.put("versionReporte", "1.0");

        String fechaActual = DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(LocalDate.now());

        parametrosLocales.put("fechaReporte", fechaActual);

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