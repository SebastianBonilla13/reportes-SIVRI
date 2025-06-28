package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
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
    public byte[] generarReporte(ReporteTipo2DTOPeticion datos) {

        // Lógica para llenar el reporte con datos del DTOReporte
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Nombre", datos.getNombre());
        parametros.put("Identificacion", datos.getIdentificacion());
        parametros.put("Grupo", datos.getGrupo());
        parametros.put("ID Grupo", datos.getIdGrupo());
        parametros.put("Codigo GrupLAC", datos.getCodigoGrupLAC());
        parametros.put("Enlace GrupLAC", datos.getEnlaceGrupLAC());
        parametros.put("Historial Roles", datos.getHistorialRoles());
        parametros.put("Estado", datos.getEstado());
        parametros.put("Tipo Vinculacion", datos.getTipoVinculacion());
        parametros.put("Facultad", datos.getFacultad());
        parametros.put("Departamento", datos.getDepartamento());
        parametros.put("Programas", datos.getProgramas());
        parametros.put("Entidad", datos.getEntidad());

        // Se llama al servicio para generar el reporte. La plantilla y los parámetros
        return JasperService.generarPdfDesdePlantilla(Plantilla, parametros);
    }

    @Override
    public Class<ReporteTipo2DTOPeticion> getDtoType() {
        return ReporteTipo2DTOPeticion.class;
    }

    @Override
    public String getPlantilla() {
        return Plantilla;
    }

}