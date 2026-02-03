package State;
import Entity.Item;
import VendingMachine.VendingMachine;
import Entity.CoinType;

public class IdleState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        vendingMachine.setSelectedItem(null);
        vendingMachine.setInsertedCoin(null);
    }

    @Override
    public void selectProduct(String itemName) {
        Item item = vendingMachine.getItemInventory().getItemFromName(itemName);
        vendingMachine.setSelectedItem(item);
        vendingMachine.setVendingMachineState(new ReadyState(vendingMachine));
    }

    @Override
    public void insertCoins(CoinType coin) {
        System.out.println("Waiting for Item to be selected...");
    }

    @Override
    public void dispense() {
        System.out.println("Waiting for Item to be selected...");
    }

    @Override
    public int returnRemainingBalance() {
        System.out.println("Waiting for Item to be selected...");
        return -1;
    }
}
