package edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import edu.unicauca.reportes_SIVRI.reportes.aplicacion.output.ReporteFormateadorResultadosIntPort;
import edu.unicauca.reportes_SIVRI.reportes.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;

@Service
public class ReporteFormateadorResultadosImplAdapter implements ReporteFormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        throw new ReglaNegocioExcepcion(mensaje);
    }
    
}
