package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicauca.reportes_SIVRI.dto.ProyectoDTO;
import edu.unicauca.reportes_SIVRI.dto.ReporteProyectoRequest;
import edu.unicauca.reportes_SIVRI.reportes.aplicacion.input.GenerarReporteCUIntPort;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteDTOPeticion;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
public class ReportesRestController {

    private final GenerarReporteCUIntPort objGenerarReporteCUIntPort;

    @PostMapping("generar")
    public ResponseEntity<byte[]> generarReporte(@RequestBody ReporteDTOPeticion objReporte) {

        String formato = objReporte.getFormato(); // Debes agregar este campo en tu DTO y en el JSON
        byte[] archivo = objGenerarReporteCUIntPort.generarReporte(objReporte.getData(), objReporte.getTipoReporte(),formato);

        String filename;
        MediaType mediaType;

        switch (formato.toLowerCase()) {
            case "xlsx":
            case "excel":
                filename = "reporte.xlsx";
                mediaType = MediaType
                        .parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                break;
            case "docx":
            case "word":
                filename = "reporte.docx";
                mediaType = MediaType
                        .parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                break;
            case "pdf":
            default:
                filename = "reporte.pdf";
                mediaType = MediaType.APPLICATION_PDF;
                break;
        }

        return buildFileResponse(archivo, filename, mediaType);
    }

    @GetMapping("/hola")
    public String holaMundo() {
        return "Hola Mundo";
    }

    private ResponseEntity<byte[]> buildFileResponse(byte[] file, String filename, MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType); // tipo de contenido dinámico, pdf, excel, etc.
        headers.setContentDisposition(ContentDisposition.inline().filename(filename).build()); // establecer el nombre
                                                                                               // del archivo
        return new ResponseEntity<>(file, headers, HttpStatus.OK); // construccion respuesta
    }

}
