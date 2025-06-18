package edu.unicauca.reportes_SIVRI.service;

public interface ReporteService<T> {
    byte[] generarReporte(String tipoReporte, T datos);
}