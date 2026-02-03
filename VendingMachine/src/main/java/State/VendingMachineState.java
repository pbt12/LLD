package State;

import Entity.CoinType;

public interface VendingMachineState {
    public void selectProduct(String itemName);
    public void insertCoins(CoinType coin);
    public void dispense();
    public int returnRemainingBalance();
}
