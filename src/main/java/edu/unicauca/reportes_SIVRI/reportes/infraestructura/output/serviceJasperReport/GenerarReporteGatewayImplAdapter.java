package edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.serviceJasperReport;

import java.util.Map;

import org.springframework.stereotype.Service;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.GenerarReporteGatewayIntPort;

@Service
public class GenerarReporteGatewayImplAdapter implements GenerarReporteGatewayIntPort {

    private final JasperHelper jasperService = new JasperHelper();

	@Override
	public byte[] generarReporteDesdePlantilla(String plantillaJrxml, Map<String, Object> parametrosYDatos, String formato) {
		
		return jasperService.generarReporteDesdePlantilla(plantillaJrxml, parametrosYDatos, formato);
	}
    
}
