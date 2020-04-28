package Rooms;

import Entities.Entity;
import Items.Item;

public class TreasureRoom extends Room{

    /**
     * private variable item
     */
    private Item item;


    /**
     * Sets new item
     * @param item: newItem
     */
    public void setItem(Items.Item item){
        this.item = item;
    }

    /**
     * Prompts entity to swap item with new item from treasure room.
     * @param entity: currEntity
     */
    public void interact(Entities.Entity entity){

        entity.promptSwap(this.item);

    }

}
