package edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteStrategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo1Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo1CStrategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo1FStrategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo2Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo3Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo4Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo4CStrategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo5Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo6Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo7Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo8Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo10Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipo11Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipoVIGStrategy;

// Se está registra estrategias en el mapa strategies bajo una clave

@Component
public class ReporteStrategyFactory {

    private final Map<String, ReporteStrategy<?>> strategies;

    /* @Autowired */
    public ReporteStrategyFactory(
            ReporteTipo1Strategy reporteTipo1Strategy,
            ReporteTipo1CStrategy reporteTipo1CStrategy,
            ReporteTipo1FStrategy reporteTipo1FStrategy,
            ReporteTipo2Strategy reporteTipo2Strategy,
            ReporteTipo3Strategy reporteTipo3Strategy,
            ReporteTipo4Strategy reporteTipo4Strategy,
            ReporteTipo4CStrategy reporteTipo4CStrategy,
            ReporteTipo5Strategy reporteTipo5Strategy,
            ReporteTipo6Strategy reporteTipo6Strategy,
            ReporteTipo7Strategy reporteTipo7Strategy,
            ReporteTipo8Strategy reporteTipo8Strategy,
            ReporteTipo10Strategy reporteTipo10Strategy,
            ReporteTipo11Strategy reporteTipo11Strategy,
            ReporteTipoVIGStrategy reporteTipoVIGStrategy
    ) {
        strategies = new HashMap<>();
        strategies.put("R01", reporteTipo1Strategy);
        strategies.put("R01-C", reporteTipo1CStrategy);
        strategies.put("R01-F", reporteTipo1FStrategy);
        strategies.put("R02", reporteTipo2Strategy);
        strategies.put("R03", reporteTipo3Strategy);
        strategies.put("R04", reporteTipo4Strategy);
        strategies.put("R04-C", reporteTipo4CStrategy);
        strategies.put("R05", reporteTipo5Strategy);
        strategies.put("R06", reporteTipo6Strategy);
        strategies.put("R07", reporteTipo7Strategy);
        strategies.put("R08", reporteTipo8Strategy);
        strategies.put("R10", reporteTipo10Strategy);
        strategies.put("R11", reporteTipo11Strategy);
        strategies.put("VIG", reporteTipoVIGStrategy);
    }

    public ReporteStrategy<?> getStrategy(String tipoReporte) {
        ReporteStrategy<?> strategy = strategies.get(tipoReporte);
        return strategy;
    }
}