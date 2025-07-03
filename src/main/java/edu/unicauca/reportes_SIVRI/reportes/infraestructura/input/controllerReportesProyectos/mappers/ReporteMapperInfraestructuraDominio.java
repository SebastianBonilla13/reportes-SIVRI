package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.mappers;

import org.mapstruct.Mapper;

import edu.unicauca.reportes_SIVRI.reportes.dominio.modelos.Reporte;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteDTOPeticion;

@Mapper(componentModel = "spring")
public interface ReporteMapperInfraestructuraDominio {

    Reporte mappearDePeticionAReporte(ReporteDTOPeticion dto);
    ReporteDTOPeticion mappearDeReporteAPeticion(Reporte reporte);

}
