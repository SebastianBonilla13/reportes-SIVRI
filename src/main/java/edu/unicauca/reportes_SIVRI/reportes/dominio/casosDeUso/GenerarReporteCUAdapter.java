package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.input.GenerarReporteCUIntPort;
import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.GenerarReporteGatewayIntPort;
import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.ReporteFormateadorResultadosIntPort;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.factory.ReporteStrategyFactory;
import edu.unicauca.reportes_SIVRI.reportes.dominio.modelos.Reporte;

public class GenerarReporteCUAdapter implements GenerarReporteCUIntPort {

    private final ReporteStrategyFactory ReporteStrategyFactory;
    private final GenerarReporteGatewayIntPort objGenerarReporteGateway;
    private final ReporteFormateadorResultadosIntPort objReporteFormateadorResultados;

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    // configuracion en Bean
    public GenerarReporteCUAdapter(ReporteStrategyFactory ReporteStrategyFactory,
            GenerarReporteGatewayIntPort objGenerarReporteGateway,
            ReporteFormateadorResultadosIntPort objReporteFormateadorResultados) {
        this.ReporteStrategyFactory = ReporteStrategyFactory;
        this.objGenerarReporteGateway = objGenerarReporteGateway;
        this.objReporteFormateadorResultados = objReporteFormateadorResultados;
    }

    @Override
    public byte[] generarReporte(Reporte objReporte) {

        System.out.println("HASTA AQUIIIIIIIII");

        byte[] archivoReporteGenerado = null;

        Object lstDTOReporte = objReporte.getData();
        String tipoReporte = objReporte.getTipoReporte();
        String formato = objReporte.getFormato();

        // 1. Obtener la estategia (reporte) según el tipo de reporte
        var reporteStrategy = ReporteStrategyFactory.getStrategy(tipoReporte);

        if (reporteStrategy != null) {

            // 2. Convertir el listado DTO a una lista de datos usando ObjectMapper, de tipo
            // específico
            List<?> datos = objectMapper.convertValue(lstDTOReporte, reporteStrategy.getTypeReference());

            if (datos != null && !datos.isEmpty()) {

                if (objReporte.validarFormato()) {
                    
                    // 3. Preparar los parámetros y datos para el reporte
                    var plantilla = reporteStrategy.getPlantilla();
                    System.out.println("DATOS ANTES DE PREPARAR PARAMETROS: " + datos);
                    var parametrosYDatos = reporteStrategy.prepararParametros((List) datos);
                    System.out.println("DATOS PREPARADOS PARA EL REPORTE: " + parametrosYDatos);
                    archivoReporteGenerado = objGenerarReporteGateway.generarReporteDesdePlantilla(plantilla, parametrosYDatos, formato);
                    return archivoReporteGenerado;

                } else {

                    System.out.println("");
                    System.out.println("ENTRA FORMATO A REPORTE INVALIDO");
                    System.out.println("");

                    // throw new IllegalArgumentException("El formato de reporte es inválido");
                    this.objReporteFormateadorResultados
                            .retornarRespuestaErrorReglaDeNegocio(
                                    "El formato de reporte es inválido. Intente con pdf, xlsx o docx");
                }

            } else {
                // throw new IllegalArgumentException("Los datos del reporte no pueden estar
                // vacíos");
                System.out.println("");
                System.out.println("ENTRA A DATOS REPORTES NO VACIOS");
                System.out.println("");

                this.objReporteFormateadorResultados
                        .retornarRespuestaErrorReglaDeNegocio(
                                "Los datos del reporte no pueden estar vacíos");
            }

        } else {
            // throw new IllegalArgumentException("Tipo de reporte no válido: " +
            // tipoReporte);
            System.out.println("");
            System.out.println("ENTRA A TIPO REPORTE NO VALIDO");
            System.out.println("");

            this.objReporteFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "Tipo de reporte no válido: " + tipoReporte);
        }

        return archivoReporteGenerado;

    }

}
