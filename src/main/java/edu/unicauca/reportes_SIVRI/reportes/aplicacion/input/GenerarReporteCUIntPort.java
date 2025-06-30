package edu.unicauca.reportes_SIVRI.reportes.aplicacion.input;


public interface GenerarReporteCUIntPort {
    
    public byte[] generarReporte(Object DTOReporte, String tipoReporte, String formato);

}
