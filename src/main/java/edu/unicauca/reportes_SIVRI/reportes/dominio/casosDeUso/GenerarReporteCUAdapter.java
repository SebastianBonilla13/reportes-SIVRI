package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.input.GenerarReporteCUIntPort;
import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.GenerarReporteGatewayIntPort;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.factory.ReporteStrategyFactory;
import edu.unicauca.reportes_SIVRI.reportes.dominio.modelos.Reporte;

public class GenerarReporteCUAdapter implements GenerarReporteCUIntPort {

    private final ReporteStrategyFactory ReporteStrategyFactory;
    private final GenerarReporteGatewayIntPort objGenerarReporteGateway;

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    // configuracion en Bean
    public GenerarReporteCUAdapter(ReporteStrategyFactory ReporteStrategyFactory,
            GenerarReporteGatewayIntPort objGenerarReporteGateway) {
        this.ReporteStrategyFactory = ReporteStrategyFactory;
        this.objGenerarReporteGateway = objGenerarReporteGateway;
    }

    @Override
    public byte[] generarReporte(Reporte objReporte) {

        System.out.println("HASTA AQUIIIIIIIII");
        
        if (objReporte.validarFormato() == false) {
            throw new IllegalArgumentException("El formato de reporte es inválido");
        }

        Object lstDTOReporte = objReporte.getData();
        String tipoReporte = objReporte.getTipoReporte();
        String formato = objReporte.getFormato();

        // 1. Obtener la estategia (reporte) según el tipo de reporte
        var reporteStrategy = ReporteStrategyFactory.getStrategy(tipoReporte);

        if (reporteStrategy == null) {
            throw new IllegalArgumentException("Tipo de reporte no válido: " + tipoReporte);
        }

        // 2. Convertir el listado DTO a una lista de datos usando ObjectMapper, de tipo
        // específico
        List<?> datos = objectMapper.convertValue(lstDTOReporte, reporteStrategy.getTypeReference());

        // 3. Validar que los datos no estén vacíos
        if (datos == null || datos.isEmpty()) {
            throw new IllegalArgumentException("Los datos del reporte no pueden estar vacíos");
        }

        // 4. Preparar los parámetros y datos para el reporte
        var plantilla = reporteStrategy.getPlantilla();
        var parametrosYDatos = reporteStrategy.prepararParametros((List) datos);

        var archivoReporteGenerado = objGenerarReporteGateway.generarReporteDesdePlantilla(plantilla, parametrosYDatos, formato);

        return archivoReporteGenerado;

    }

}
