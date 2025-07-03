package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

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
        
        // Usar el primer elemento para los parámetros simples
        ReporteTipo2DTOPeticion dto = datos.get(0);

        // Preparar los parámetros para el reporte
        Map<String, Object> parametros = new HashMap<>();
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