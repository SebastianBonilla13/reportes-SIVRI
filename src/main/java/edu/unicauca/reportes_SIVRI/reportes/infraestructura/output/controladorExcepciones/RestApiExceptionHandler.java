package edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* import javax.servlet.http.HttpServletRequest; */
/* import javax.validation.ConstraintViolationException; */
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones.estructuraExcepciones.Error;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones.estructuraExcepciones.ErrorUtils;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
/* import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException; */
/* import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException; */

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
            final Exception ex, final Locale locale) {
        System.out.println("ENTRA A EXCEPTION GENERICA");
        final edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones.estructuraExcepciones.Error error = ErrorUtils
                .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                        CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ReglaNegocioExcepcion.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
            final ReglaNegocioExcepcion ex, final Locale locale) {
        System.out.println("ENTRA A VIOLACION REGLA DE NEGOCIO");
        final Error error = ErrorUtils
                .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(), ex.formatException(),
                        HttpStatus.BAD_REQUEST.value())
                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        System.out.println("ENTRA A EXCEPCION DE VALIDACION");
        System.out.println("Retornando respuesta con los errores identificados");
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campo = ((FieldError) error).getField();
            String mensajeDeError = error.getDefaultMessage();
            errores.put(campo, mensajeDeError);
        });

        return new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        System.out.println("ENTRA A EXCEPCION DE VIOLACION DE REGLA DE NEGOCIO");
        return new ResponseEntity<>(e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

}
