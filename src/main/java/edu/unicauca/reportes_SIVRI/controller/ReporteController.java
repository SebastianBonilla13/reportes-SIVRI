package edu.unicauca.reportes_SIVRI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicauca.reportes_SIVRI.dto.ProyectoDTO;
import edu.unicauca.reportes_SIVRI.dto.ReporteProyectoRequest;
import edu.unicauca.reportes_SIVRI.service.ProyectoService;
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
@RequestMapping("/api/reportes")
@RequiredArgsConstructor

public class ReporteController {

    private final ProyectoService proyectoService;

    @PostMapping("/proyecto")
    public ResponseEntity<byte[]> generarReporteProyecto(@RequestBody ReporteProyectoRequest request) {
        ProyectoDTO proyectoDTO = request.getData();
        String tipoReporte = request.getTipoReporte();

        byte[] pdf = proyectoService.generarReporte(tipoReporte, proyectoDTO);

        // archivo, nombre del archivo descarga y tipo de contenido
        return buildFileResponse(pdf, "reporte_proyecto.pdf", MediaType.APPLICATION_PDF);
    }

    // Realizar pruebas para recibir varios proyectos y generar un reporte en excel



    @PostMapping("/proyectooooo")
    public ResponseEntity<byte[]> generarReporteProyecto(@RequestBody ProyectoDTO ProyectoDTO) {
        // TODO: process POST request

        // imprimir el proyecto recibido
        System.out.println("Proyecto recibido: " + ProyectoDTO);

        byte[] pdf = proyectoService.generarReporte("VIGENCIA", ProyectoDTO);

        // archivo, nombre del archivo descarga y tipo de contenido
        return buildFileResponse(pdf, "reporte_proyecto.pdf", MediaType.APPLICATION_PDF);
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
