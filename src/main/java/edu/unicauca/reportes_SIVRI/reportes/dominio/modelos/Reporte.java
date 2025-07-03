package edu.unicauca.reportes_SIVRI.reportes.dominio.modelos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Reporte {
    private Object data; // Puede ser cualquier tipo de lista
    private String tipoReporte; // Referencia tipo reporte
    private String formato; // PDF, csv, docx, etc.

    public boolean validarFormato() {
        String formatoLower = this.formato.toLowerCase(); // Convertir a minusculas
        return formatoLower.equals("pdf") || formatoLower.equals("xlsx") || formatoLower.equals("docx");
    }

}
