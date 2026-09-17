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
public class ReporteTipo1FDTOPeticion {

    // =========================================================
    // INFORMACIÓN GENERAL DEL GRUPO
    // =========================================================

    private String idGrupo;
    private String nombreGrupo;
    private String codigoGruplac;
    private String enlaceGruplac;

    private String directorGrupo;
    private String correoDirectorGrupo;
    private String correoGrupo;

    private String facultadGrupo;
    private String departamentoDirector;

    private String lineasInvestigacionGrupo;
    private String categorizacionGrupo;
    private String disciplinasGrupo;

    private String estadoGrupo;
    private String fechaCreacionGruplac;

    // =========================================================
    // FICHA ENVIADA POR EL FRONT
    // =========================================================

    /*
     * El front envía la ficha con el nombre "DataFicha".
     * Internamente se mantiene el nombre Java "dataFicha".
     */
    @JsonAlias("DataFicha")
    private List<FichaDTO> dataFicha;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FichaDTO {

        private String idGrupo;
        private String nombreGrupo;

        private List<IntegranteDTO> integrantes;
        private List<ProyectoDTO> proyectos;
        private List<SemilleroDTO> semilleros;
        private List<ProductoEntregadoDTO> productosEntregados;
        private List<ProductoPendienteDTO> productosPendientes;
    }

    // =========================================================
    // INTEGRANTES
    // =========================================================

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IntegranteDTO {

        private String numeroIdentificacion;
        private String nombreIntegrante;
        private String historialRolesEnGrupo;
        private String estadoIntegranteGrupo;
    }

    // =========================================================
    // PROYECTOS
    // =========================================================

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProyectoDTO {

        private String idProyecto;
        private String tipoProyecto;
        private String nombreConvocatoria;
    }

    // =========================================================
    // SEMILLEROS
    // =========================================================

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SemilleroDTO {

        private String idSemillero;
        private String nombreSemillero;
        private String fechaCreacionSemillero;
        private String estadoSemillero;
    }

    // =========================================================
    // PRODUCTOS ENTREGADOS
    // =========================================================

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProductoEntregadoDTO {

        private String representanteProductoEntregado;
        private String tipoProductoEntregado;
        private String nombreResponsableProductoEntregado;
    }

    // =========================================================
    // PRODUCTOS PENDIENTES
    // =========================================================

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProductoPendienteDTO {

        private String representanteProductoPendiente;
        private String tipoProductoPendiente;
        private String nombreResponsableProductoPendiente;
    }
}
