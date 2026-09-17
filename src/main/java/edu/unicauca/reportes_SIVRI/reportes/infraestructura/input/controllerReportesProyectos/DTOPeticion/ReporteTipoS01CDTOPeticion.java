package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteTipoS01CDTOPeticion {

    // =========================================================
    // INFORMACIÓN GENERAL DEL SEMILLERO
    // =========================================================

    private String idSemillero;
    private String nombreSemillero;

    /*
     * El front real no envía idGrupo en el objeto raíz,
     * pero se conserva por compatibilidad con el JRXML.
     * La Strategy puede recuperarlo desde el primer integrante.
     */
    private String idGrupo;
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

    // =========================================================
    // INTEGRANTES DEL SEMILLERO
    // =========================================================

    /*
     * El front envía esta propiedad con el nombre
     * "DataIntegrantesSemillero".
     */
    @JsonAlias("DataIntegrantesSemillero")
    private List<IntegranteSemilleroDTO> integrantesSemillero;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IntegranteSemilleroDTO {

        private String nombreIntegrante;
        private String numeroIdentificacion;

        private String idSemillero;
        private String nombreSemillero;

        private String nombreGrupo;
        private String idGrupo;

        private String enlaceCvlac;

        private String historialRolesEnSemillero;

        private String fechaInicioRol;
        private String fechaFinRol;

        private String estadoIntegranteSemillero;
        private String tipoVinculacionIntegrante;

        private String facultadIntegrante;
        private String departamentoIntegrante;
        private String programaIntegrante;

        private String facultadSemillero;
        private String departamentoSemillero;
        private String fechaCreacionSemillero;
    }
}
