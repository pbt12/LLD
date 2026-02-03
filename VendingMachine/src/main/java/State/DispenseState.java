package State;

import Entity.CoinType;
import Entity.Item;
import VendingMachine.VendingMachine;

public class DispenseState implements VendingMachineState{

    public VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String itemName) {
        System.out.println("Dispense under process...");
    }

    @Override
    public void insertCoins(CoinType coin) {
        System.out.println("Dispense under process...");
    }

    @Override
    public void dispense() {
        vendingMachine.getItemInventory().reduceItem(vendingMachine.selectedItem);
        //return vendingMachine.getSelectedItem();
        System.out.println("Item dispensed");
        vendingMachine.setVendingMachineState(new SettleBalanceState(vendingMachine) );
    }

    @Override
    public int returnRemainingBalance() {
        System.out.println("Waiting for Item to be dispensed...");
        return -1;
    }
}
