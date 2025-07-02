package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteTipo1DTOPeticion;
@Component
public class ReporteTipo1Strategy implements ReporteStrategy<ReporteTipo1DTOPeticion> {

    private static final String Plantilla = "/reportes/ReporteTipo1.jrxml";
    private static final Map<String, Object> parametros = new HashMap<>();

    @Override
    public Map<String, Object> prepararParametros(List<ReporteTipo1DTOPeticion> datos) {

        if (datos == null || datos.isEmpty()) {
            throw new IllegalArgumentException("La lista de datos no puede estar vacía");
        }

        // Usar el primer elemento para los parámetros simples
        ReporteTipo1DTOPeticion dto = datos.get(0);

        // Preparar los parámetros para el reporte
       Map<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", dto.getTitulo());
        parametros.put("idproyecto", dto.getIdProyecto());
        parametros.put("diaini", String.format("%02d", dto.getFechaInicio().getDayOfMonth()));
        parametros.put("mesini", String.format("%02d", dto.getFechaInicio().getMonthValue()));
        parametros.put("anioini", dto.getFechaInicio().getYear());
        parametros.put("diafin", String.format("%02d", dto.getFechaFinalizacion().getDayOfMonth()));
        parametros.put("mesfin", String.format("%02d", dto.getFechaFinalizacion().getMonthValue()));
        parametros.put("aniofin", dto.getFechaFinalizacion().getYear());
        parametros.put("director", dto.getDirector());

        // Convertir la lista de DTOs a una lista de mapas para el reporte
        parametros.put("DATA_LIST", datos);

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipo1DTOPeticion>> getTypeReference() {
        return new TypeReference<List<ReporteTipo1DTOPeticion>>() {
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