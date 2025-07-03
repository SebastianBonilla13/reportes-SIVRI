package edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.formateador;

import org.springframework.http.MediaType;

public enum FormatoReporte {
    PDF("pdf", "reporte.pdf", MediaType.APPLICATION_PDF),
    XLSX("xlsx", "reporte.xlsx", MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")),
    DOCX("docx", "reporte.docx", MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"));

    private final String formato; // tipo de formato
    private final String nombreArchivo; // nombre del archivo a generar
    private final MediaType mediaType; // tipo de contenido

    FormatoReporte(String formato, String nombreArchivo, MediaType mediaType) {
        this.formato = formato;
        this.nombreArchivo = nombreArchivo;
        this.mediaType = mediaType;
    }

    public String getNombreArchivo(){ 
        return nombreArchivo;
    }
    
    public MediaType getMediaType(){
        return mediaType;
    }

    public static FormatoReporte tipoFormato(String formato) {
        if (formato == null) return PDF;
        switch (formato.toLowerCase()) {
            case "xlsx":
            case "excel": return XLSX;
            case "docx":
            case "word": return DOCX;
            case "pdf":
            default: return PDF; // PDF formato por defecto
        }
    }
}