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
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipoS01Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipoS01CStrategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipoS02Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipoS03Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipoS04Strategy;
import edu.unicauca.reportes_SIVRI.reportes.dominio.casosDeUso.strategies.ReporteTipoS05Strategy;

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
            ReporteTipoS01Strategy reporteTipoS01Strategy,
            ReporteTipoS01CStrategy reporteTipoS01CStrategy,
            ReporteTipoS02Strategy reporteTipoS02Strategy,
            ReporteTipoS03Strategy reporteTipoS03Strategy,
            ReporteTipoS04Strategy reporteTipoS04Strategy,
            ReporteTipoS05Strategy reporteTipoS05Strategy
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
        strategies.put("S01", reporteTipoS01Strategy);
        strategies.put("S01-C", reporteTipoS01CStrategy);
        strategies.put("S02", reporteTipoS02Strategy);
        strategies.put("S03", reporteTipoS03Strategy);
        strategies.put("S04", reporteTipoS04Strategy);
        strategies.put("S05", reporteTipoS05Strategy);
    }

    public ReporteStrategy<?> getStrategy(String tipoReporte) {
        ReporteStrategy<?> strategy = strategies.get(tipoReporte);
        return strategy;
    }
}