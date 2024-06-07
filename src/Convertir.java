import java.util.Map;

public class Convertir {
    private String base_code;
    private String target_code;
    private double conversion_result;
    private Map<String, Double> conversion_rates;

    public Convertir(String base_code, String target_code, double conversion_result) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_result = conversion_result;
    }

    public String base_code() {
        return base_code;
    }

    public String target_code() {
        return target_code;
    }

    public double conversion_result() {
        return conversion_result;
    }

    public double getConversionRate(String target_code) {
        return conversion_rates.get(target_code);
    }
}
