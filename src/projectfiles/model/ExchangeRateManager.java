package projectfiles.model;

import java.util.HashMap;
import java.util.Map;


/**
 * This class models  the exchange rate of currency.
 */

public class ExchangeRateManager {
    private Map<String, Map<String, Double>> exchangeRates;

    public ExchangeRateManager() {
        exchangeRates = new HashMap<>();
    }

    /**
     * Getter for exchange rate given source and target currency
     * @param from Source currency. i.e USD
     * @param to Target currency. i.e EUR
     * @return A double containing the rate
     */
    public double getExchangeRate(String from, String to) {
        if (exchangeRates.containsKey(from) && exchangeRates.get(from).containsKey(to)) {
            return exchangeRates.get(from).get(to);
        } else {
            // Handle if exchange rate is not found
            return -1; // Placeholder value for not found
        }
    }

    /**
     * Method to update exchange rate from external source.
     * @param from A string containing the source currency
     * @param to A string containing the target currency.
     * @param rate a double containing the rate.
     */
    public void updateExchangeRate(String from, String to, double rate) {
        if (!exchangeRates.containsKey(from)) {
            exchangeRates.put(from, new HashMap<>());
        }
        exchangeRates.get(from).put(to, rate);
    }
}
