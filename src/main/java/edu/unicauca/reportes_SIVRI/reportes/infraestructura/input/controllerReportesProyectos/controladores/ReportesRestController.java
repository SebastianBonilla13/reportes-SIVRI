package edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.input.GenerarReporteCUIntPort;
import edu.unicauca.reportes_SIVRI.reportes.dominio.modelos.Reporte;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.DTOPeticion.ReporteDTOPeticion;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.input.controllerReportesProyectos.mappers.ReporteMapperInfraestructuraDominio;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.formateador.FormatoReporte;
import jakarta.validation.Valid;
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
    private final ReporteMapperInfraestructuraDominio objMapeador;

    @PostMapping("generar")
    public ResponseEntity<byte[]> generarReporte(@RequestBody @Valid ReporteDTOPeticion objReporte) {

        Reporte objReporteGenerar = objMapeador.mappearDePeticionAReporte(objReporte);
        byte[] archivoReporteGenerado = objGenerarReporteCUIntPort.generarReporte(objReporteGenerar);

        FormatoReporte formatoReporte = FormatoReporte.tipoFormato(objReporteGenerar.getFormato());

        return buildFileResponse(archivoReporteGenerado, formatoReporte.getNombreArchivo(), formatoReporte.getMediaType());
    }

    // utilidades 
    private ResponseEntity<byte[]> buildFileResponse(byte[] file, String filename, MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType); // tipo de contenido dinámico, pdf, excel, etc.
        headers.setContentDisposition(ContentDisposition.inline().filename(filename).build()); // establecer el nombre
                                                                                               // del archivo
        return new ResponseEntity<>(file, headers, HttpStatus.OK); // construccion respuesta
    }

    @GetMapping("/hola")
    public String holaMundo() {
        return "Hola Mundo";
    }

}
