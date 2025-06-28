package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteTipo1DTOPeticion;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.service.JasperHelper;

@Component
public class ReporteTipo1Strategy implements ReporteStrategy<ReporteTipo1DTOPeticion> {

    private static final String Plantilla = "/reportes/ReporteTipo1.jrxml";
    private final JasperHelper JasperService;

    public ReporteTipo1Strategy(JasperHelper JasperService) {
        this.JasperService = JasperService;
    }

    @Override
    public byte[] generarReporte(ReporteTipo1DTOPeticion datos) {

        // Lógica para llenar el reporte con datos del DTOReporte
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", datos.getTitulo());
        parametros.put("idproyecto", datos.getIdProyecto()); // Nombre exacto requerido por Jasper
        parametros.put("diaini", String.format("%02d", datos.getFechaInicio().getDayOfMonth()));
        parametros.put("mesini", String.format("%02d", datos.getFechaInicio().getMonthValue()));
        parametros.put("anioini", Integer.valueOf(datos.getFechaInicio().getYear()));
        parametros.put("diafin", String.format("%02d", datos.getFechaFinalizacion().getDayOfMonth()));
        parametros.put("mesfin", String.format("%02d", datos.getFechaFinalizacion().getMonthValue()));
        parametros.put("aniofin", Integer.valueOf(datos.getFechaFinalizacion().getYear()));
        parametros.put("director", datos.getDirector());
        
        // Se llama al servicio para generar el reporte. La plantilla y los parámetros
        return JasperService.generarPdfDesdePlantilla(Plantilla, parametros);
    }

    @Override
    public Class<ReporteTipo1DTOPeticion> getDtoType() {
        return ReporteTipo1DTOPeticion.class;
    }

    @Override
    public String getPlantilla() {
        return Plantilla;
    }

}