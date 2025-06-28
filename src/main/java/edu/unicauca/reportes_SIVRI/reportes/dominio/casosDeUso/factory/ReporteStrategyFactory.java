package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteStrategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo1Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo2Strategy;

// Se está registra estrategias en el mapa strategies bajo una clave

@Component
public class ReporteStrategyFactory {

    private final Map<String, ReporteStrategy<?>> strategies;

    /* @Autowired */
    public ReporteStrategyFactory(
        ReporteTipo1Strategy reporteTipo1Strategy,
        ReporteTipo2Strategy reporteTipo2Strategy
        /* ReporteTipo2Strategy reporteTipo2Strategy */
        // ...
    ) {
        strategies = new HashMap<>();
        strategies.put("R01", reporteTipo1Strategy);
        strategies.put("R02", reporteTipo2Strategy);
        /* strategies.put("R02", reporteTipo2Strategy); */
        // ...
    }

    public ReporteStrategy<?> getStrategy(String tipoReporte) {
        ReporteStrategy<?> strategy = strategies.get(tipoReporte);
        if (strategy == null) {
            throw new IllegalArgumentException("Tipo de reporte no soportado: " + tipoReporte);
        }
        return strategy;
    }
}