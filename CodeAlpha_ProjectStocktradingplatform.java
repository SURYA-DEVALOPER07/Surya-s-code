import java.util.*;

class Stock {
    String symbol;
    String name;
    double price;

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return symbol + " - " + name + " : $" + price;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;
        if (cost > balance) {
            System.out.println("❌ Not enough balance to buy " + quantity + " shares of " + stock.symbol);
            return;
        }
        balance -= cost;
        holdings.put(stock.symbol, holdings.getOrDefault(stock.symbol, 0) + quantity);
        System.out.println("✅ Bought " + quantity + " shares of " + stock.symbol);
    }

    public void sellStock(Stock stock, int quantity) {
        int owned = holdings.getOrDefault(stock.symbol, 0);
        if (quantity > owned) {
            System.out.println("❌ You don’t own enough shares to sell!");
            return;
        }
        double revenue = stock.price * quantity;
        balance += revenue;
        holdings.put(stock.symbol, owned - quantity);
        System.out.println("✅ Sold " + quantity + " shares of " + stock.symbol);
    }

    public void viewPortfolio(Map<String, Stock> market) {
        System.out.println("\n📊 === PORTFOLIO REPORT ===");
        double totalValue = balance;
        for (String symbol : holdings.keySet()) {
            int qty = holdings.get(symbol);
            double price = market.get(symbol).price;
            double value = qty * price;
            totalValue += value;
            System.out.println(symbol + " - Shares: " + qty + ", Value: $" + value);
        }
        System.out.println("Cash Balance: $" + balance);
        System.out.println("Total Portfolio Value: $" + totalValue);
        System.out.println("=============================\n");
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize market stocks
        Map<String, Stock> market = new HashMap<>();
        market.put("AAPL", new Stock("AAPL", "Apple Inc.", 190.50));
        market.put("GOOG", new Stock("GOOG",
