package State;

import Entity.CoinType;
import VendingMachine.VendingMachine;

public class ReadyState implements VendingMachineState{

     VendingMachine vendingMachine;

     public ReadyState(VendingMachine vendingMachine){
         this.vendingMachine = vendingMachine;
     }

    @Override
    public void selectProduct(String itemName) {
        System.out.println("Product is already selected..!!!");
    }

    @Override
    public void insertCoins(CoinType insertedCoin) {
        vendingMachine.setInsertedCoin(insertedCoin);
        System.out.println("Inserted Coin: " + insertedCoin.getValue());
        if(vendingMachine.getSelectedItem().getPrice() <= insertedCoin.getValue()){
            System.out.println("Sufficient money was inserted.");
            vendingMachine.getMoneyInventory().addMoney(insertedCoin, 1);
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine));
        }
    }

    @Override
    public void dispense() {
        System.out.println("Waiting for payment to be made...");
    }

    @Override
    public int returnRemainingBalance() {
        System.out.println("Waiting for payment to be made...");
        return -1;
    }
}
