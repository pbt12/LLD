package VendingMachine;

import Entity.CoinType;
import Entity.Item;
import Entity.ItemInventory;

public class VendingMachineDemo {
    public void start(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.getItemInventory().addItem(new Item("Soda", 1));
        vendingMachine.getItemInventory().addItem(new Item("Biscuit", 5));
        vendingMachine.getItemInventory().addItem(new Item("Samosa", 10));
        vendingMachine.getItemInventory().addItem(new Item("Gum", 50));

        vendingMachine.getMoneyInventory().addMoney(CoinType.ONE, 10);
        vendingMachine.getMoneyInventory().addMoney(CoinType.TWO, 10);
        vendingMachine.getMoneyInventory().addMoney(CoinType.FIVE, 10);
        vendingMachine.getMoneyInventory().addMoney(CoinType.TEN, 10);
        vendingMachine.getMoneyInventory().addMoney(CoinType.FIFTY, 10);
        vendingMachine.getMoneyInventory().addMoney(CoinType.HUNDRED, 10);

        vendingMachine.selectItem("Soda");
        vendingMachine.insertCoin(CoinType.FIVE);
        vendingMachine.dispenseItem();
        int remBalance = vendingMachine.settleBalance();
        System.out.println("Remaining balance is: " + remBalance);

    }


}
