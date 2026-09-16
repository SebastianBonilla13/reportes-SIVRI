package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteTipoS01DTOPeticion {

    private String idSemillero;
    private String nombreSemillero;

    private String nombreGrupo;

    private String facultadSemillero;
    private String departamentoSemillero;
    private String programasSemillero;

    private String mentorSemillero;
    private String coordinadorSemillero;

    private String correoMentor;
    private String correoSemillero;

    private String lineasInvestigacionSemillero;

    private String objetivoSemillero;

    private String disciplinasSemillero;

    private String estadoSemillero;

    private String informePlanTrabajoSemillero;

    private String fechaCreacionSemillero;
}