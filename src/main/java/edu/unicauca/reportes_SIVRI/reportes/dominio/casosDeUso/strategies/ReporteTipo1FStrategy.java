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
        .ReporteTipo1FDTOPeticion;

@Component
public class ReporteTipo1FStrategy
        implements ReporteStrategy<ReporteTipo1FDTOPeticion> {

    private static final String Plantilla =
            "/reportes/R01-F.jrxml";

    private static final Map<String, Object> parametros =
            new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(
            List<ReporteTipo1FDTOPeticion> datos) {

        Map<String, Object> parametrosLocales =
                new HashMap<>();

        if (datos != null && !datos.isEmpty()) {

            /*
             * R01-F corresponde a la ficha de un grupo.
             * La petición real envía un arreglo cuyo primer
             * elemento contiene el grupo y sus cinco listas.
             */
            ReporteTipo1FDTOPeticion ficha = datos.get(0);

            // =====================================================
            // DATOS GENERALES DEL GRUPO
            // =====================================================

            parametrosLocales.put(
                    "idGrupo",
                    ficha.getIdGrupo()
            );

            parametrosLocales.put(
                    "nombreGrupo",
                    ficha.getNombreGrupo()
            );

            parametrosLocales.put(
                    "codigoGruplac",
                    ficha.getCodigoGruplac()
            );

            parametrosLocales.put(
                    "categorizacionGrupo",
                    ficha.getCategorizacionGrupo()
            );

            parametrosLocales.put(
                    "facultadGrupo",
                    ficha.getFacultadGrupo()
            );

            // =====================================================
            // TABLAS
            // =====================================================

            parametrosLocales.put(
                    "LISTA_INTEGRANTES",
                    ficha.getIntegrantes() != null
                            ? ficha.getIntegrantes()
                            : new ArrayList<>()
            );

            parametrosLocales.put(
                    "LISTA_PROYECTOS",
                    ficha.getProyectos() != null
                            ? ficha.getProyectos()
                            : new ArrayList<>()
            );

            parametrosLocales.put(
                    "LISTA_SEMILLEROS",
                    ficha.getSemilleros() != null
                            ? ficha.getSemilleros()
                            : new ArrayList<>()
            );

            parametrosLocales.put(
                    "LISTA_PRODUCTOS_ENTREGADOS",
                    ficha.getProductosEntregados() != null
                            ? ficha.getProductosEntregados()
                            : new ArrayList<>()
            );

            parametrosLocales.put(
                    "LISTA_PRODUCTOS_PENDIENTES",
                    ficha.getProductosPendientes() != null
                            ? ficha.getProductosPendientes()
                            : new ArrayList<>()
            );

            /*
             * JasperHelper necesita DATA_LIST.
             *
             * Dejamos un único registro para que la banda detail
             * se ejecute una sola vez y dentro de ella se impriman
             * las cinco tablas.
             */
            List<ReporteTipo1FDTOPeticion> dataList =
                    new ArrayList<>();

            dataList.add(ficha);

            parametrosLocales.put(
                    "DATA_LIST",
                    dataList
            );

        } else {

            parametrosLocales.put(
                    "LISTA_INTEGRANTES",
                    new ArrayList<>()
            );

            parametrosLocales.put(
                    "LISTA_PROYECTOS",
                    new ArrayList<>()
            );

            parametrosLocales.put(
                    "LISTA_SEMILLEROS",
                    new ArrayList<>()
            );

            parametrosLocales.put(
                    "LISTA_PRODUCTOS_ENTREGADOS",
                    new ArrayList<>()
            );

            parametrosLocales.put(
                    "LISTA_PRODUCTOS_PENDIENTES",
                    new ArrayList<>()
            );

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
                "Ficha resumen grupos de investigación"
        );

        parametrosLocales.put(
                "codigoReporte",
                "R01-F"
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
    public TypeReference<List<ReporteTipo1FDTOPeticion>>
            getTypeReference() {

        return new TypeReference<
                List<ReporteTipo1FDTOPeticion>>() {
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