package edu.unicauca.reportes_SIVRI.reportes.aplicacion.input;

import edu.unicauca.reportes_SIVRI.reportes.dominio.modelos.Reporte;

public interface GenerarReporteCUIntPort {
    
    public byte[] generarReporte(Reporte objReporte);

}
