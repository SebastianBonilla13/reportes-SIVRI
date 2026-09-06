package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteTipoVIGDTOPeticion;

@Component
public class ReporteTipoVIGStrategy implements ReporteStrategy<ReporteTipoVIGDTOPeticion> {

    private static final String Plantilla = "/reportes/ReporteTipo1.jrxml";
    private static final Map<String, Object> parametros = new HashMap<>();

//    @Override
//    public Map<String, Object> prepararParametros(List<ReporteTipo3DTOPeticion> datos) {
//
//        // Preparar parámetros para el reporte
//        Map<String, Object> parametros = new HashMap<>();
//
//        // Parametros generales del reporte
//        parametros.put("tituloReporte", "Reporte de Integrantes de Grupos de Investigación y no sé que másssss");
//        parametros.put("codigoReporte", "R03");
//        parametros.put("versionReporte", "1.1.1.1");
//
//        String fechaActual = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(java.time.LocalDate.now());
//        parametros.put("fechaReporte", fechaActual);
//
//        // Agregar datos tabla
//        parametros.put("DATA_LIST", datos);
//


//        return parametros;
//    }

    @Override
    public Map<String, Object> prepararParametros(List<ReporteTipoVIGDTOPeticion> datos) {
        Map<String, Object> parametros = new HashMap<>();

        if (datos != null && !datos.isEmpty()) {
            ReporteTipoVIGDTOPeticion proyecto = datos.get(0);

            // 1. Mapeo para que Jasper reemplace los $P{}
            parametros.put("titulo", proyecto.getTitulo());
            parametros.put("idproyecto", proyecto.getIdProyecto());
            parametros.put("director", proyecto.getDirector());

            if (proyecto.getFechaInicio() != null) {
                parametros.put("diaini", String.format("%02d", proyecto.getFechaInicio().getDayOfMonth()));
                parametros.put("mesini", String.format("%02d", proyecto.getFechaInicio().getMonthValue()));
                parametros.put("anioini", proyecto.getFechaInicio().getYear());
            }

            if (proyecto.getFechaFinalizacion() != null) {
                parametros.put("diafin", String.format("%02d", proyecto.getFechaFinalizacion().getDayOfMonth()));
                parametros.put("mesfin", String.format("%02d", proyecto.getFechaFinalizacion().getMonthValue()));
                parametros.put("aniofin", proyecto.getFechaFinalizacion().getYear());
            }
        }

        parametros.put("tituloReporte", "Reporte de Integrantes de Grupos de Investigación y no sé que másssss");
        parametros.put("codigoReporte", "R03");
        parametros.put("versionReporte", "1.1.1.1");

        String fechaActual = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(java.time.LocalDate.now());
        parametros.put("fechaReporte", fechaActual);

        // 2. ¡CLAVE! Devolver la lista al mapa para que Jasper imprima la banda <detail>
        parametros.put("DATA_LIST", datos);

        return parametros;
    }

    @Override
    public TypeReference<List<ReporteTipoVIGDTOPeticion>> getTypeReference() {
        return new TypeReference<List<ReporteTipoVIGDTOPeticion>>() {
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