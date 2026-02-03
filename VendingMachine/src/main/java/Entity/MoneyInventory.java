package Entity;

import java.util.HashMap;

public class MoneyInventory {
    HashMap<CoinType, Integer> quantityMap;

    public MoneyInventory(){
        quantityMap = new HashMap<>();
    }

    public boolean isAvailable(CoinType coinType, Integer quantity){
        return quantityMap.getOrDefault(coinType, 0) >= quantity;
    }

    public void reduceMoney(CoinType coinType, Integer quantity){
        quantityMap.put(coinType, quantityMap.get(coinType)-quantity);
    }

    public void addMoney(CoinType coinType, Integer quantity){
        quantityMap.put(coinType, quantityMap.getOrDefault(coinType, 0) + 1);
    }
}
