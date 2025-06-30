package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;


import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteTipo2DTOPeticion;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.service.JasperHelper;

@Component
public class ReporteTipo2Strategy implements ReporteStrategy<ReporteTipo2DTOPeticion> {

    private static final String Plantilla = "/reportes/Integrantes_Grupos.jrxml";
    private final JasperHelper JasperService;

    public ReporteTipo2Strategy(JasperHelper JasperService) {
        this.JasperService = JasperService;
    }

    @Override
    public byte[] generarReporte(List<ReporteTipo2DTOPeticion> datos, String formato) {

        if (datos == null || datos.isEmpty()) {
            throw new IllegalArgumentException("La lista de datos no puede estar vacía");
        }

        // Usar el primer elemento para los parámetros simples
        ReporteTipo2DTOPeticion dto = datos.get(0);

        System.out.println("");
        System.out.println("DATOSSSS: " + datos);
        System.out.println("");

        // Preparar los parámetros para el reporte
        Map<String, Object> parametros = new HashMap<>();
        /*
         * parametros.put("Nombre", dto.getNombre());
         * parametros.put("Identificacion", dto.getIdentificacion());
         * parametros.put("Grupo", dto.getGrupo());
         * parametros.put("ID Grupo", dto.getIdGrupo());
         * parametros.put("Codigo GrupLAC", dto.getCodigoGrupLAC());
         * parametros.put("Enlace GrupLAC", dto.getEnlaceGrupLAC());
         * parametros.put("Historial Roles", dto.getHistorialRoles());
         * parametros.put("Estado", dto.getEstado());
         * parametros.put("Tipo Vinculacion", dto.getTipoVinculacion());
         * parametros.put("Facultad", dto.getFacultad());
         * parametros.put("Departamento", dto.getDepartamento());
         * parametros.put("Programas", dto.getProgramas());
         * parametros.put("Entidad", dto.getEntidad());
         */

        parametros.put("nombre", dto.getNombre());
        parametros.put("identificacion", dto.getIdentificacion());
        parametros.put("grupo", dto.getGrupo());
        parametros.put("idGrupo", dto.getIdGrupo());
        parametros.put("codigoGrupLAC", dto.getCodigoGrupLAC());
        parametros.put("enlaceGrupLAC", dto.getEnlaceGrupLAC());
        parametros.put("historialRoles", dto.getHistorialRoles());
        parametros.put("estado", dto.getEstado());
        parametros.put("tipoVinculacion", dto.getTipoVinculacion());
        parametros.put("facultad", dto.getFacultad());
        parametros.put("departamento", dto.getDepartamento());
        parametros.put("programas", dto.getProgramas());
        parametros.put("entidad", dto.getEntidad());

        // Convertir la lista de DTOs a una lista de mapas para el reporte
        parametros.put("DATA_LIST", datos);

        // Se llama al servicio para generar el reporte. La plantilla y los parámetros
        return JasperService.generarReporteDesdePlantilla(Plantilla, parametros, formato);
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

}