package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.input.GenerarReporteCUIntPort;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.factory.ReporteStrategyFactory;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteStrategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.modelos.Reporte;

public class GenerarReporteCUAdapter implements GenerarReporteCUIntPort {

    private final ReporteStrategyFactory ReporteStrategyFactory;
    //private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule()); // cambiar logica
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    // configurar en Bean?
    public GenerarReporteCUAdapter(ReporteStrategyFactory ReporteStrategyFactory) {
        this.ReporteStrategyFactory = ReporteStrategyFactory;
    }

    @Override
    public byte[] generarReporte(Object DTOReporte, String tipoReporte, String formato) {

        // 1. Obtener la estategia (reporte) según el tipo de reporte
        var reporteStrategy = ReporteStrategyFactory.getStrategy(tipoReporte);

        System.out.println("");
        System.out.println("PLANTILLA " + reporteStrategy.getPlantilla());
        System.out.println("");

        // 2. Mapear el DTO genérico al tipo especifico esperado
        /*
         * Class dtoType = reporteStrategy.getDtoType();
         * Object dtoEspecifico = objectMapper.convertValue(DTOReporte, dtoType);
         */

        /* Object dtoEspecifico;
        if (reporteStrategy.getDtoType() != null) {
            dtoEspecifico = objectMapper.convertValue(DTOReporte, reporteStrategy.getClass());
        } else {
            dtoEspecifico = objectMapper.convertValue(DTOReporte, reporteStrategy.getDtoType());
        }
        */

        /* @SuppressWarnings("unchecked") */
        //List<?> datos = objectMapper.convertValue(DTOReporte, reporteStrategy.getDtoType());

        List<?> datos = objectMapper.convertValue(DTOReporte, reporteStrategy.getTypeReference());

        // 3. Validar el DTO específico (puedes usar javax.validation aquí si lo deseas)

        // 4. Generar el reporte usando la estrategia
        // return reporteStrategy.generarReporte(dtoEspecifico);

        return ((ReporteStrategy) reporteStrategy).generarReporte((List) datos, formato);

    }

}
