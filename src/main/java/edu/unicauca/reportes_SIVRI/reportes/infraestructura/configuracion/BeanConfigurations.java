package edu.unicauca.reportes_SIVRI.reportes.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.GenerarReporteGatewayIntPort;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.GenerarReporteCUAdapter;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.factory.ReporteStrategyFactory;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public GenerarReporteCUAdapter crearGenerarReporteCUAdapter
    (ReporteStrategyFactory ReporteStrategyFactory,
     GenerarReporteGatewayIntPort objGenerarReporteGateway) {
        GenerarReporteCUAdapter objGenerarReporteCU =  new GenerarReporteCUAdapter(ReporteStrategyFactory, objGenerarReporteGateway);
        return objGenerarReporteCU;
    }

}
