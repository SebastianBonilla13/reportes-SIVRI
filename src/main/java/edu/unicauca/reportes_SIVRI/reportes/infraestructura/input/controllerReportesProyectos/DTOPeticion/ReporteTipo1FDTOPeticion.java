package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteTipo1FDTOPeticion {

    // =========================================================
    // DATOS GENERALES DEL GRUPO
    // =========================================================

    private String idGrupo;
    private String nombreGrupo;
    private String codigoGruplac;
    private String categorizacionGrupo;
    private String facultadGrupo;

    // =========================================================
    // LISTAS DE LA FICHA
    // =========================================================

    private List<IntegranteDTO> integrantes;
    private List<ProyectoDTO> proyectos;
    private List<SemilleroDTO> semilleros;
    private List<ProductoEntregadoDTO> productosEntregados;
    private List<ProductoPendienteDTO> productosPendientes;

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