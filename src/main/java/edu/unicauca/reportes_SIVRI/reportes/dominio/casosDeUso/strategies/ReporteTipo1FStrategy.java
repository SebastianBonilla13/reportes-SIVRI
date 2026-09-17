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
        .ReporteTipo1FDTOPeticion;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura
        .input.controllerReportesProyectos.DTOPeticion
        .ReporteTipo1FDTOPeticion.FichaDTO;

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
             * El front envía data como una lista con un objeto raíz.
             * Ese objeto contiene:
             *
             * 1. Información general del grupo.
             * 2. Una lista "DataFicha".
             *
             * DataFicha contiene un único objeto con las cinco listas
             * que alimentan las tablas del JRXML.
             */
            ReporteTipo1FDTOPeticion grupo = datos.get(0);

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
                    "categorizacionGrupo",
                    grupo.getCategorizacionGrupo()
            );

            parametrosLocales.put(
                    "facultadGrupo",
                    grupo.getFacultadGrupo()
            );

            // =====================================================
            // FICHA
            // =====================================================

            FichaDTO ficha = null;

            if (grupo.getDataFicha() != null
                    && !grupo.getDataFicha().isEmpty()) {

                ficha = grupo.getDataFicha().get(0);
            }

            if (ficha != null) {

                // Parámetros de listas. Se mantienen porque el JRXML
                // ya los declara y pueden ser reutilizados.
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
                 * IMPORTANTE:
                 *
                 * El JRXML actual usa:
                 *   $F{integrantes}
                 *   $F{proyectos}
                 *   $F{semilleros}
                 *   $F{productosEntregados}
                 *   $F{productosPendientes}
                 *
                 * Por eso DATA_LIST debe contener la FichaDTO.
                 * Se agrega una única ficha para que las bandas detail
                 * se ejecuten una sola vez.
                 */
                List<FichaDTO> dataList =
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
                .format(LocalDate.now());

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
