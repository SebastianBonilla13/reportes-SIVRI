package edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Component
public class JasperHelper {

    public static byte[] generarPdfDesdePlantilla(String plantillaJrxml, Map<String, Object> parametros) {
            System.out.println(" ");
            System.out.println("ANTESS DE COMPILAR: " + plantillaJrxml);
            System.out.println(" ");
        try (InputStream input = JasperHelper.class.getResourceAsStream(plantillaJrxml)) {
            if (input == null) {
                throw new FileNotFoundException("No se encontró el archivo .jrxml: " + plantillaJrxml);
            }

            System.out.println(" ");
            System.out.println("ANTESS DE COMPILAR: " + plantillaJrxml);
            System.out.println(" ");

            // Compilar el .jrxml en tiempo de ejecución
            JasperReport report = JasperCompileManager.compileReport(input);

            // Llenar el reporte con JREmptyDataSource si no se necesita iterar datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());

            // Exportar a PDF
            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            throw new RuntimeException("Error al generar el reporte desde archivo .jrxml", e);
        }
    }

}
