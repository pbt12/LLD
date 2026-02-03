package State;

import Entity.CoinType;
import VendingMachine.VendingMachine;

public class SettleBalanceState implements VendingMachineState{

    VendingMachine vendingMachine;

    public SettleBalanceState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String itemName) {
        System.out.println("Waiting for balance settlement");
    }

    @Override
    public void insertCoins(CoinType coin) {
        System.out.println("Waiting for balance settlement");
    }

    @Override
    public void dispense() {
        System.out.println("Waiting for balance settlement");
    }

    @Override
    public int returnRemainingBalance() {
        if(vendingMachine.getInsertedCoin().getValue() > vendingMachine.getSelectedItem().getPrice()){
            vendingMachine.getMoneyInventory()
                    .reduceMoney(CoinType.ONE, vendingMachine.getInsertedCoin().getValue() - vendingMachine.getSelectedItem().getPrice());
            // Dispersion Strategy to get the coins
            System.out.print("Coins dispensed..");
        }else{
            System.out.println("Thanks for shopping");
        }
        int remainingBal = vendingMachine.getInsertedCoin().getValue() - vendingMachine.getSelectedItem().getPrice();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return remainingBal;
    }
}
