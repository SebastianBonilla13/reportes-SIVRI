package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.input.GenerarReporteCUIntPort;
import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.GenerarReporteGatewayIntPort;
import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.ReporteFormateadorResultadosIntPort;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.factory.ReporteStrategyFactory;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteStrategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.modelos.Reporte;

public class GenerarReporteCUAdapter implements GenerarReporteCUIntPort {

    private final ReporteStrategyFactory ReporteStrategyFactory;
    private final GenerarReporteGatewayIntPort objGenerarReporteGateway;
    private final ReporteFormateadorResultadosIntPort objReporteFormateadorResultados;

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    // configuracion en Bean
    public GenerarReporteCUAdapter(
            ReporteStrategyFactory ReporteStrategyFactory,
            GenerarReporteGatewayIntPort objGenerarReporteGateway,
            ReporteFormateadorResultadosIntPort objReporteFormateadorResultados) {

        this.ReporteStrategyFactory = ReporteStrategyFactory;
        this.objGenerarReporteGateway = objGenerarReporteGateway;
        this.objReporteFormateadorResultados = objReporteFormateadorResultados;
    }

    @Override
    public byte[] generarReporte(Reporte objReporte) {

        System.out.println("HASTA AQUIIIIIIIII");

        Object lstDTOReporte = objReporte.getData();
        String tipoReporte = objReporte.getTipoReporte();
        String formato = objReporte.getFormato();

        // 1. Obtener la estrategia (reporte) según el tipo de reporte
        ReporteStrategy<?> reporteStrategy =
                ReporteStrategyFactory.getStrategy(tipoReporte);

        if (reporteStrategy != null) {

            /*
             * La conversión de los datos y la llamada a prepararParametros(...)
             * se realizan dentro de un método genérico.
             *
             * De esta forma Java conserva el tipo T de la estrategia y no es
             * necesario convertir List<?> a List sin parametrizar.
             */
            return procesarReporte(
                    reporteStrategy,
                    lstDTOReporte,
                    objReporte,
                    formato
            );

        } else {

            System.out.println("");
            System.out.println("ENTRA A TIPO REPORTE NO VALIDO");
            System.out.println("");

            this.objReporteFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "Tipo de reporte no válido: " + tipoReporte
                    );
        }

        return null;
    }

    /**
     * Procesa un reporte conservando el tipo concreto de la estrategia.
     *
     * @param reporteStrategy estrategia seleccionada para el tipo de reporte
     * @param lstDTOReporte datos recibidos en la petición
     * @param objReporte objeto de dominio del reporte
     * @param formato formato solicitado
     * @param <T> DTO específico manejado por la estrategia
     * @return archivo generado o null cuando se presenta una validación de negocio
     */
    private <T> byte[] procesarReporte(
            ReporteStrategy<T> reporteStrategy,
            Object lstDTOReporte,
            Reporte objReporte,
            String formato) {

        // 2. Convertir los datos al tipo específico definido por la estrategia
        List<T> datos = objectMapper.convertValue(
                lstDTOReporte,
                reporteStrategy.getTypeReference()
        );

        if (datos != null && !datos.isEmpty()) {

            if (objReporte.validarFormato()) {

                // 3. Preparar los parámetros y datos para el reporte
                String plantilla = reporteStrategy.getPlantilla();

                System.out.println(
                        "DATOS ANTES DE PREPARAR PARAMETROS: " + datos
                );

                Map<String, Object> parametrosYDatos =
                        reporteStrategy.prepararParametros(datos);

                System.out.println(
                        "DATOS PREPARADOS PARA EL REPORTE: " + parametrosYDatos
                );

                return objGenerarReporteGateway.generarReporteDesdePlantilla(
                        plantilla,
                        parametrosYDatos,
                        formato
                );

            } else {

                System.out.println("");
                System.out.println("ENTRA FORMATO A REPORTE INVALIDO");
                System.out.println("");

                this.objReporteFormateadorResultados
                        .retornarRespuestaErrorReglaDeNegocio(
                                "El formato de reporte es inválido. Intente con pdf, xlsx o docx"
                        );
            }

        } else {

            System.out.println("");
            System.out.println("ENTRA A DATOS REPORTES NO VACIOS");
            System.out.println("");

            this.objReporteFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "Los datos del reporte no pueden estar vacíos"
                    );
        }

        return null;
    }
}