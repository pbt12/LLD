package VendingMachine;

import Entity.CoinType;
import Entity.Item;
import Entity.ItemInventory;
import Entity.MoneyInventory;
import State.IdleState;
import State.VendingMachineState;

import java.util.HashMap;

public class VendingMachine {

    private MoneyInventory moneyInventory;
    private final ItemInventory itemInventory = new ItemInventory();
    private CoinType insertedCoin;
    VendingMachineState vendingMachineState;
    public Item selectedItem;


    public VendingMachine(){
        selectedItem = null;
        vendingMachineState = new IdleState(this);
        moneyInventory = new MoneyInventory();
    }

    public void selectItem(String itemName){
        vendingMachineState.selectProduct(itemName);
    }

    public void insertCoin(CoinType coinType){
        vendingMachineState.insertCoins(coinType);
    }
    public void dispenseItem(){
        vendingMachineState.dispense();
    }
    public int settleBalance(){
        return vendingMachineState.returnRemainingBalance();
    }

    // Getters and setters
    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }
    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }
    public Item getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }
    public CoinType getInsertedAmount() {
        return insertedCoin;
    }
    public void setInsertedCoin(CoinType insertedCoin) {
        this.insertedCoin = insertedCoin;
    }
    public ItemInventory getItemInventory() {
        return itemInventory;
    }
    public CoinType getInsertedCoin() {
        return insertedCoin;
    }
    public void setMoneyInventory(MoneyInventory moneyInventory) {
        this.moneyInventory = moneyInventory;
    }
    public MoneyInventory getMoneyInventory() {
        return moneyInventory;
    }
}
