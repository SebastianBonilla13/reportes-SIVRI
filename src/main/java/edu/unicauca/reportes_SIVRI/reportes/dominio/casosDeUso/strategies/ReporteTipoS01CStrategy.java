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
        .ReporteTipoS01CDTOPeticion;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion
        .ReporteTipoS01CDTOPeticion.IntegranteSemilleroDTO;

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
             * El front envía data como una lista con un único
             * objeto raíz del semillero.
             *
             * Ese objeto contiene:
             * 1. La información general del semillero.
             * 2. La lista anidada "DataIntegrantesSemillero".
             */
            ReporteTipoS01CDTOPeticion semillero =
                    datos.get(0);

            List<IntegranteSemilleroDTO> integrantes =
                    semillero.getIntegrantesSemillero() != null
                            ? semillero.getIntegrantesSemillero()
                            : new ArrayList<>();

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

            /*
             * El payload real no trae idGrupo en el objeto raíz.
             * Además, los integrantes pueden traer idGrupo distintos,
             * por lo que no se debe inferir un único valor desde la lista.
             * Si el front no lo envía a nivel general, el parámetro queda null
             * y el JRXML lo mostrará vacío.
             */
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

            // =====================================================
            // TABLA DE INTEGRANTES
            // =====================================================

            /*
             * JasperHelper construye el JRBeanCollectionDataSource
             * a partir de DATA_LIST.
             *
             * Por eso DATA_LIST debe contener directamente
             * DataIntegrantesSemillero.
             */
            parametrosLocales.put(
                    "DATA_LIST",
                    integrantes
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
                .format(LocalDate.now());

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
