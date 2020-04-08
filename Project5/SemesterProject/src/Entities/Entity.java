package Entities;

import Items.Item;

public abstract class Entity {

    private double attack;
    private double defense;
    private double health;
    private double mana;
    private boolean swappingItem;
    private Entity enemy;

    public Entity getEnemy() {
        return enemy;
    }

    public double getHealth() {
        return health;
    }

    public void damage(double amount){
        // damage entity
    }

    public double getMana() {
        return mana;
    }

    public void drainMana(double amount){

    }

    public Item getHelmet() {
        // get helmet
        return null;
    }

    public Item getArmor() {
        // get armor
        return null;
    }

    public Item getMainHand() {
        // get main hand item
        return null;
    }

    public Item getOffHand() {
        // get off hand item
        return null;
    }

    public boolean isSwappingItem() {
        return swappingItem;
    }

    public abstract void battle() {

    }
}
