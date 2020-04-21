package Entities;

import Interactions.Observer;
import Items.*;
import Interactions.Interactable;

import java.util.ArrayList;

public abstract class Entity extends Interactable{

    private int health;
    private int mana;
    private ArrayList<Item> items = new ArrayList<>();
    private boolean swappingItem = false;
    private Entity enemy;
    protected String description;

    public Entity(String description){
        this.description = description;
        this.health = 100;
        this.mana = 100;
    }

    public void setEnemy(Entity enemy) {
        this.enemy = enemy;
    }

    /**
     * Returns list of items owned by the entity
     * NOTE: This will be important for displaying the items a user has
     *
     * @return ArrayList<Item> items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Checks if an item of the same type is already equipped
     *  - if yes: replace with new item
     *  - if no:  add new item
     *
     * @param newItem
     */
    public void equipItem(Item newItem) {

        for(int i = 0; i < this.items.size(); i++) {
            Item currentItem = this.items.get(i);
            if(currentItem.getClass().equals(newItem.getClass())){
                Item oldItem = this.items.get(i);
                this.items.set(i, newItem);

                return;
            }
        }
        this.items.add(newItem);
    }

    /**
     * Ask a user if they want to swap the item equipped for the given item
     * NOTE: This will require the graphics element for confirmation
     *
     * @param newItem
     */
    public void promptSwap(Item newItem){
        swappingItem = true;
        // swap stuff, this will require the graphics to be implemented
    }

    /**
     * Used by graphics element to determine if an item is currently being swapped
     *
     * @return
     */
    public boolean isSwappingItem() {
        return swappingItem;
    }

    /**
     * Attack defined by items being held
     * @return
     */
    public int getAttack() {
        int attack = 0;

        for (Item item:this.items) {
            attack += item.getAttack();
        }

        return attack;
    }

    /**
     * Defense defined by items being held
     * @return
     */
    public int getDefense() {
        int defense = 0;

        for (Item item:this.items) {
            defense += item.getDefense();
        }

        return defense;
    }

    /**
     * returns enemy
     * Note: This will be important for the Graphics to get the battle state
     *
     * @return Entity - the current enemy of this entity
     */
    public Entity getEnemy() {
        return enemy;
    }

    public int getHealth() {
        return health;
    }

    /**
     * Damage is afflicted to entity based on damage and defense of the entity
     *
     * @param amount - how much pre-defense damage being dealt
     */
    public void damage(int amount){
        this.health -= amount/(this.getDefense() + 1);
    }

    public String getDescription() {
        return description;
    }

    /**
     * Returns string containing entity:
     *  - description
     *  - health
     *  - mana
     *  - attack
     *  - defense
     *  - items
     *
     *
     * @return
     */
    @Override
    public String toString() {
        String fullDescription = description;
        fullDescription += " || Health: " + this.getHealth();
        fullDescription += " || Mana: " + this.getMana();
        fullDescription += " || Attack: " + this.getAttack();
        fullDescription += " || Defense: " + this.getDefense();
        fullDescription += " || ";
        if(this.items.size() > 0)  {
            fullDescription += " Equipped items: ";
            for (Item item:this.items) {
                fullDescription += item.getDescription() + ", ";
            }
        }
        return fullDescription.substring(0, fullDescription.length()-2);
    }

    public int getMana() {
        return mana;
    }

    /**
     * Subtracts a given amount of mana from an entity
     * TODO: determine if we want to use defense to help calculate the mana drained
     *
     * @param amount - how much mana to drain from entity
     */
    public void drainMana(int amount){
        this.mana -= amount;
    }

    /**
     * Has entity take their turn in a battle
     *
     * @param opponent - who the entity is fighting
     */
    public void battle(Entity opponent) {
        this.enemy = opponent;

        System.out.println(this); // TODO: delete when done debugging

        Skill testSkill = this.makeMove();
        testSkill.activate(this, opponent);

        if(opponent.getHealth() <= 0) {
            System.out.println(this.getClass().getSimpleName() + " Wins!"); // TODO: change this to go back to the floor
        } else {
            opponent.battle(this);
        }
    }

    /**
     * Each child class of Entity will determine how to select moves for battle
     *
     * @return Skill - The skill they entity wants to use
     */
    abstract protected Skill makeMove();

    /**
     * useful for displaying skills and enemy deciding what skill to use
     *
     * @return ArrayList<Skill> - list of skills entity can use
     */
    public ArrayList<Skill> getSkills() {
        // get skills from items
        ArrayList<Skill> skills = new ArrayList<>();

        for (Item item:this.items) {
           skills.add(item.getSkill());
        }

        return skills;
    }

    // TODO: implement observable stuff
    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

}
