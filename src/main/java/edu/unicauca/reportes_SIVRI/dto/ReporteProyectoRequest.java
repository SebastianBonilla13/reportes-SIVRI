package edu.unicauca.reportes_SIVRI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReporteProyectoRequest {
    private ProyectoDTO data;
    private String tipoReporte;

    /* public ProyectoDTO getData() {
        return data;
    }

    public void setData(ProyectoDTO data) {
        this.data = data;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    } */
}