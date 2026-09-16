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
        .ReporteTipoS01CDTOPeticion;

@Component
public class ReporteTipoS01CStrategy
        implements ReporteStrategy<ReporteTipoS01CDTOPeticion> {

    private static final String Plantilla =
            "/reportes/S01-C.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipoS01CDTOPeticion> datos) {

        Map<String, Object> parametrosLocales =
                new HashMap<>();

        if (datos != null && !datos.isEmpty()) {

            /*
             * La petición viene como lista plana.
             * Todos los registros corresponden al mismo semillero.
             *
             * Tomamos el primero para la información general.
             */
            ReporteTipoS01CDTOPeticion semillero =
                    datos.get(0);

            // =====================================================
            // INFORMACIÓN GENERAL DEL SEMILLERO
            // =====================================================

            parametrosLocales.put(
                    "idSemillero",
                    semillero.getIdSemillero()
            );

            parametrosLocales.put(
                    "nombreSemillero",
                    semillero.getNombreSemillero()
            );

            parametrosLocales.put(
                    "idGrupo",
                    semillero.getIdGrupo()
            );

            parametrosLocales.put(
                    "nombreGrupo",
                    semillero.getNombreGrupo()
            );

            parametrosLocales.put(
                    "facultadSemillero",
                    semillero.getFacultadSemillero()
            );

            parametrosLocales.put(
                    "departamentoSemillero",
                    semillero.getDepartamentoSemillero()
            );

            parametrosLocales.put(
                    "fechaCreacionSemillero",
                    semillero.getFechaCreacionSemillero()
            );

            /*
             * Campos 8 - 16:
             * la misma lista plana alimenta la tabla
             * de integrantes.
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

        // =========================================================
        // METADATOS DEL REPORTE
        // =========================================================

        parametrosLocales.put(
                "tituloReporte",
                "Certificados de semilleros de investigación e integrantes"
        );

        parametrosLocales.put(
                "codigoReporte",
                "S01-C"
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
    public TypeReference<List<ReporteTipoS01CDTOPeticion>>
            getTypeReference() {

        return new TypeReference<
                List<ReporteTipoS01CDTOPeticion>>() {
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