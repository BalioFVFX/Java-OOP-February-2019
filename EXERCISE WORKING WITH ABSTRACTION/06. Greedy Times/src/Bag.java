import money.Cash;
import money.Gem;
import money.Gold;
import money.Money;

import java.util.LinkedHashMap;

public class Bag {
    private LinkedHashMap<String, Gold> gold;
    private LinkedHashMap<String, Cash> cash;
    private LinkedHashMap<String, Gem> gems;
    private long capacity;

    public Bag(long capacity) {
        this.gold = new LinkedHashMap<>();
        this.gems = new LinkedHashMap<>();
        this.cash = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public void addGold(Gold gold) {
        long totalGold = this.getTotalGold();
        long totalGems = this.getTotalGems();
        if (totalGold < totalGems || !hasCapacity(gold.getPrice())) {
            return;
        }


        if (this.gold.containsKey("Gold")) {
            this.gold.get("Gold").incrementPriceBy(gold.getPrice());
        } else {
            this.gold.put("Gold", gold);
        }

    }

    public void addGems(Gem gem) {
        long totalGems = this.getTotalGems();
        long totalCash = this.getTotalCash();
        long totalGold = this.getTotalGold();

        if (totalGems < totalCash || !hasCapacity(gem.getPrice()) || totalGold < totalGems + gem.getPrice()) {
            return;
        }

        if (this.gems.containsKey(gem.getName())) {
            this.gems.get(gem.getName()).incrementPriceBy(gem.getPrice());
        } else {
            this.gems.put(gem.getName(), gem);
        }
    }

    public void addCash(Cash cash) {
        long totalGem = this.getTotalGems();
        long totalCash = this.getTotalCash();
        if (!hasCapacity(cash.getPrice()) || totalGem < totalCash + cash.getPrice()) {
            return;
        }

        if (this.cash.containsKey(cash.getName())) {
            this.cash.get(cash.getName()).incrementPriceBy(cash.getPrice());
        } else {
            this.cash.put(cash.getName(), cash);
        }
    }

    private boolean hasCapacity(long itemValue) {
        return this.getTotalCash() + this.getTotalGems() + this.getTotalGold() + itemValue <= this.capacity;
    }

    private long getTotalCash() {
        return this.cash.values().stream().mapToLong(Money::getPrice).sum();
    }

    private long getTotalGold() {
        return this.gold.values().stream().mapToLong(Money::getPrice).sum();
    }

    private long getTotalGems() {
        return this.gems.values().stream().mapToLong(Money::getPrice).sum();
    }

    private String getMoneySorted(LinkedHashMap<String, Money> money, Class tClass) {

        if (money.size() == 0) {
            return "";
        }
        long totalMoney = money.values().stream().mapToLong(Money::getPrice).sum();

        StringBuilder output = new StringBuilder();
        output.append(String.format("<%s> $%s", tClass.getSimpleName(), totalMoney)).append("\n");
        money.entrySet().stream().sorted((f, s) -> {
            int nameSortResult = s.getKey().compareTo(f.getKey());
            if (nameSortResult == 0) {
                return Long.compare(f.getValue().getPrice(), s.getValue().getPrice());
            }
            return nameSortResult;
        }).forEach(e -> {
            output.append(String.format("##%s - %s%n", e.getKey(), e.getValue().getPrice()));
        });

        return output.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(getMoneySorted(new LinkedHashMap<>(gold), Gold.class));
        output.append(getMoneySorted(new LinkedHashMap<>(gems), Gem.class));
        output.append(getMoneySorted(new LinkedHashMap<>(cash), Cash.class));

        return output.toString();
    }
}
