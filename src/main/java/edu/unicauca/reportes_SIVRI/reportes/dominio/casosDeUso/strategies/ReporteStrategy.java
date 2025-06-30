package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;


public interface ReporteStrategy<T> {

    byte[] generarReporte(List<T> datos, String formato);
    TypeReference<List<T>> getTypeReference();
    String getPlantilla();


}
