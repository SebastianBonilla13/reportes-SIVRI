package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import edu.unicauca.reportes_SIVRI.reportes.dominio.modelos.Reporte;

public interface ReporteStrategy<T> {

    byte[] generarReporte(T datos);
    Class<T> getDtoType();
    String getPlantilla();


}
