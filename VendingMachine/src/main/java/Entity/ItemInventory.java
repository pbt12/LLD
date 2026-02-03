package Entity;

import java.util.HashMap;

public class ItemInventory {
    HashMap<String, Integer> quantityMap;
    HashMap<String, Item> itemMap;

    public ItemInventory(){
        quantityMap = new HashMap<>();
        itemMap = new HashMap<>();
    }

    public HashMap<String, Integer> getQuantityMap() {
        return quantityMap;
    }
    public void setQuantityMap(HashMap<String, Integer> quantityMap) {
        this.quantityMap = quantityMap;
    }

    public void addItem(Item item){
        if(itemMap.containsKey(item.getName())){
            System.out.println("Item already exists in inventory, adding to inventory");
            quantityMap.put(item.getName(), quantityMap.get(item.getName())+1);
        }else{
            itemMap.put(item.getName(), item);
            quantityMap.put(item.getName(), 1);
            System.out.println("Item added to inventory");
        }
    }

    public Boolean isAvailable(Item item){
        int quantity = quantityMap.getOrDefault(item.getName(), -1);
        return quantity > 0;
    }

    public Item getItemFromName(String itemName){
        return itemMap.get(itemName);
    }

    public Item reduceItem(Item item){
        quantityMap.put(item.getName(), quantityMap.get(item.getName())-1);
        return item;
    }

}
