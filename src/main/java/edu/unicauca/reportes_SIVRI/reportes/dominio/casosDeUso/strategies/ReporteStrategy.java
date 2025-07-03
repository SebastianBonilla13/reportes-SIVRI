package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;


public interface ReporteStrategy<T> {

    /* byte[] generarReporte(List<T> datos, String formato); */
    Map<String, Object> prepararParametros(List<T> datos);
    TypeReference<List<T>> getTypeReference();
    String getPlantilla();
    Map<String, Object> getParametros();
    
}
