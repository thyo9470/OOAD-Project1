package Factories;

import Items.Item;

public class ItemFactory {

    private ItemFactory factory;

    public ItemFactory(ItemFactory factory){
        this.factory = factory;
    }

    public Item createItem(Item itemType){

        return itemType;
    }
}
