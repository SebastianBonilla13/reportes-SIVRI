package edu.unicauca.reportes_SIVRI.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.unicauca.reportes_SIVRI.dto.ProyectoDTO;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.service.JasperHelper;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Override
    public byte[] generarReporte(String tipoReporte, ProyectoDTO proyectoDTO) {

        // Validar que el tipo de reporte no sea nulo o vacío
        if (tipoReporte == null || tipoReporte.isEmpty()) {
            throw new IllegalArgumentException("El tipo de reporte no puede ser nulo o vacío");
        }

        // Validar que el proyecto no sea nulo
        if (proyectoDTO == null) {
            throw new IllegalArgumentException("El proyecto no puede ser nulo");
        }

        // Validar que el reporte tenga los campos de un ProyectoDTO
        /*
         * if (proyectoDTO.getIdProyecto() == null || proyectoDTO.getTitulo() == null ||
         * proyectoDTO.getFechaInicio() == null || proyectoDTO.getFechaFinalizacion() ==
         * null ||
         * proyectoDTO.getDirector() == null) {
         * throw new
         * IllegalArgumentException("El proyecto debe contener todos los campos necesarios"
         * );
         * }
         */

        switch (tipoReporte) {
            case "VIGENCIA":
                return generarVigenciaProyecto(proyectoDTO);
            case "FICHA_RESUMEN":
                /* return generarFichaResumen(proyecto); */
            case "OTRO":
                /* return generarOtro(proyecto); */
            default:
                throw new IllegalArgumentException("Tipo de reporte no soportado: " + tipoReporte);
        }
    }

    private byte[] procesarReporteJasper(String rutaReporte, Map<String, Object> parametros) {

        System.out.println(" ");
        System.out.println("ANTES de generar el reporte");
        System.out.println(" ");

        

        return JasperHelper.generarReporteDesdePlantilla(rutaReporte, parametros, "xlsx");
    }

    private byte[] generarVigenciaProyecto(ProyectoDTO proyecto) {

        // ruta del reporte en .jrxml
        String rutaReporte = "/reportes/vigenciaproyecto.jrxml";

        // Validar si la ruta es encontrada correctamente
        if (rutaReporte == null || rutaReporte.isEmpty()) {
            throw new IllegalArgumentException("Ruta del reporte no puede ser nula o vacía");
        }

        System.out.println(" ");
        System.out.println("RUTA ENCONTRADA");
        System.out.println(" ");

        /*
         * Map<String, Object> parametros = new HashMap<>();
         * parametros.put("idProyecto", proyecto.getIdProyecto());
         * parametros.put("titulo", proyecto.getTitulo());
         * parametros.put("estado", proyecto.getEstado());
         * parametros.put("fechaInicio", proyecto.getFechaInicio());
         * parametros.put("fechaFin", proyecto.getFechaFinalizacion());
         * parametros.put("director", proyecto.getDirector());
         * parametros.put("gruposInvestigacion", proyecto.getGruposInvestigacion());
         * parametros.put("facultades", proyecto.getFacultades());
         * parametros.put("departamentos", proyecto.getDepartamentos());
         * parametros.put("tipoProyecto", proyecto.getTipoProyecto());
         * parametros.put("convocatoria", proyecto.getNombreConvocatoria());
         * parametros.put("divisionVRI", proyecto.getDivisionVRI());
         * parametros.put("lugarEjecucion", proyecto.getLugarEjecucion());
         */

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", proyecto.getTitulo());
        parametros.put("idproyecto", proyecto.getIdProyecto()); // Nombre exacto requerido por Jasper
        parametros.put("diaini", String.format("%02d", proyecto.getFechaInicio().getDayOfMonth()));
        parametros.put("mesini", String.format("%02d", proyecto.getFechaInicio().getMonthValue()));
        parametros.put("anioini", Integer.valueOf(proyecto.getFechaInicio().getYear()));
        parametros.put("diafin", String.format("%02d", proyecto.getFechaFinalizacion().getDayOfMonth()));
        parametros.put("mesfin", String.format("%02d", proyecto.getFechaFinalizacion().getMonthValue()));
        parametros.put("aniofin", Integer.valueOf(proyecto.getFechaFinalizacion().getYear()));
        parametros.put("director", proyecto.getDirector());

        return procesarReporteJasper(rutaReporte, parametros);
    }

}
