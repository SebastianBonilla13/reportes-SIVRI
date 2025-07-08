package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.type.TypeReference;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteTipo2DTOPeticion;

@Component
public class ReporteTipo2Strategy implements ReporteStrategy<ReporteTipo2DTOPeticion> {

    private static final String Plantilla = "/reportes/Integrantes_Grupos.jrxml";
    private static final Map<String, Object> parametros = new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(List<ReporteTipo2DTOPeticion> datos) {

        // Preparar parámetros para el reporte
        Map<String, Object> parametros = new HashMap<>();

        // Parametros generales del reporte
        parametros.put("tituloReporte", "Reporte de Integrantes de Grupos de Investigación para strategy dossss");
        parametros.put("codigoReporte", "R022222");
        parametros.put("versionReporte", "1.1.1.1");
        
        String fechaActual = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(java.time.LocalDate.now());
        parametros.put("fechaReporte", fechaActual);

        // Agregar datos tabla
        parametros.put("DATA_LIST", datos);

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipo2DTOPeticion>> getTypeReference() {
        return new TypeReference<List<ReporteTipo2DTOPeticion>>() {
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