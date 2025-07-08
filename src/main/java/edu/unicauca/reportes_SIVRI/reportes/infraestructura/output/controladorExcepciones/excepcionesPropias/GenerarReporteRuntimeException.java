package edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones.excepcionesPropias;

import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GenerarReporteRuntimeException extends RuntimeException {

    protected CodigoError codigoError;
    public abstract String formatException();

}
