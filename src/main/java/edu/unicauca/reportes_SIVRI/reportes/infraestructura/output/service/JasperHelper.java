package edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;

@Component
public class JasperHelper {

    public static byte[] generarReporteDesdePlantilla(String plantillaJrxml, Map<String, Object> parametrosYDatos, String formato) {
        System.out.println(" ");
        System.out.println("ANTESS DE ENCONTRAR CARPETA: " + plantillaJrxml);
        System.out.println(" ");
        try (InputStream input = JasperHelper.class.getResourceAsStream(plantillaJrxml)) {
            if (input == null) {
                throw new FileNotFoundException("No se encontró el archivo .jrxml: " + plantillaJrxml);
            }

            System.out.println(" ");
            System.out.println("ANTESS DE COMPILAR: " + plantillaJrxml);
            System.out.println(" ");

            JasperReport report = JasperCompileManager.compileReport(input);

            Collection<?> data = (Collection<?>) parametrosYDatos.get("DATA_LIST");
            Map<String, Object> parametros = new HashMap<>(parametrosYDatos);
            parametros.remove("DATA_LIST");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, dataSource);

            if ("xlsx".equalsIgnoreCase(formato) || "excel".equalsIgnoreCase(formato)) {
                ByteArrayOutputStream xlsxStream = new ByteArrayOutputStream();
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsxStream));
                SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
                configuration.setOnePagePerSheet(false);
                exporter.setConfiguration(configuration);
                exporter.exportReport();
                return xlsxStream.toByteArray();
            } else if ("pdf".equalsIgnoreCase(formato)) {
                return JasperExportManager.exportReportToPdf(jasperPrint);
            } else if ("docx".equalsIgnoreCase(formato) || "word".equalsIgnoreCase(formato)) {
                ByteArrayOutputStream docxStream = new ByteArrayOutputStream();
                JRDocxExporter exporter = new JRDocxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(docxStream));
                SimpleDocxReportConfiguration configuration = new SimpleDocxReportConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();
                return docxStream.toByteArray();
            } else {
                throw new IllegalArgumentException("Formato de reporte no soportado: " + formato);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al generar el reporte desde archivo .jrxml", e);
        }
    }
}