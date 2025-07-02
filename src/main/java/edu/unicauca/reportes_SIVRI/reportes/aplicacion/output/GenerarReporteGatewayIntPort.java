package edu.unicauca.reportes_SIVRI.reportes.aplicacion.output;
import java.util.Map;

public interface GenerarReporteGatewayIntPort {

    byte[] generarReporteDesdePlantilla(String plantillaJrxml, Map<String, Object> parametrosYDatos, String formato);
}