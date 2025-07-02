package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.input.GenerarReporteCUIntPort;
import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.GenerarReporteGatewayIntPort;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.factory.ReporteStrategyFactory;

public class GenerarReporteCUAdapter implements GenerarReporteCUIntPort {

    private final ReporteStrategyFactory ReporteStrategyFactory;
    private final GenerarReporteGatewayIntPort objGenerarReporteGateway;

    //private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule()); // cambiar logica
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    // configurar en Bean?
    public GenerarReporteCUAdapter(ReporteStrategyFactory ReporteStrategyFactory, GenerarReporteGatewayIntPort objGenerarReporteGateway) {
        this.ReporteStrategyFactory = ReporteStrategyFactory;
        this.objGenerarReporteGateway = objGenerarReporteGateway;
    }

    @Override
    public byte[] generarReporte(Object DTOReporte, String tipoReporte, String formato) {

        // 1. Obtener la estategia (reporte) según el tipo de reporte
        var reporteStrategy = ReporteStrategyFactory.getStrategy(tipoReporte);

        System.out.println("");
        System.out.println("PLANTILLA " + reporteStrategy.getPlantilla());
        System.out.println("");

        List<?> datos = objectMapper.convertValue(DTOReporte, reporteStrategy.getTypeReference());

        // 3. Validar el DTO específico (puedes usar javax.validation aquí si lo deseas)


        var plantilla = reporteStrategy.getPlantilla();
        var parametrosYDatos = reporteStrategy.prepararParametros((List) datos);

        var reporteGenerado = objGenerarReporteGateway.generarReporteDesdePlantilla(plantilla, parametrosYDatos, formato);

        return reporteGenerado;

    }

}
