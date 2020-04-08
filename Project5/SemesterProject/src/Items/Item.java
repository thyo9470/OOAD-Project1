package Items;

import Entities.Entity;

import java.util.ArrayList;

abstract public class Item extends Entity{

   private Entity entity;
   private Skill skill;
   private String description;

    public String getDescription() {
        return description;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public ArrayList<Skill> getSkills() {
        // get skill of current item and children items
        return null;
    }

    // This might need something passed to it?
    private void swapItem() {
        // check if this is the item to swap:
        // if yes: equip
        // if no: pass to next item
    }

    // This also might need something passed to it?
    private void equipItem() {
        // equip new item
    }

    // Once again, this might need an item passed to it
    private  void removeItem() {
        // remove old item
    }

    public void battle(Entity opponent) {
        this.entity.battle(opponent);
    }
}
