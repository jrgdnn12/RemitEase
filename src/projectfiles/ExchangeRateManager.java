package projectfiles;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateManager {
    private Map<String, Map<String, Double>> exchangeRates;

    public ExchangeRateManager() {
        exchangeRates = new HashMap<>();
    }

    public double getExchangeRate(String from, String to) {
        if (exchangeRates.containsKey(from) && exchangeRates.get(from).containsKey(to)) {
            return exchangeRates.get(from).get(to);
        } else {
            // Handle if exchange rate is not found
            return -1; // Placeholder value for not found
        }
    }

    public void updateExchangeRate(String from, String to, double rate) {
        if (!exchangeRates.containsKey(from)) {
            exchangeRates.put(from, new HashMap<>());
        }
        exchangeRates.get(from).put(to, rate);
    }
}
