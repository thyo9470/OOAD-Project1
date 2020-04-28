package Entities;

import Items.*;
import Interactions.Interactable;
import Items.Skills.*;

import java.util.ArrayList;

/**
 * OBSERVER PATTERN
 * Acts as one of the observable objects in observer pattern
 */
public abstract class Entity extends Interactable {

    private int health;
    private int mana;
    private ArrayList<Item> items = new ArrayList<>();
    protected Item swappingItem;
    protected Entity enemy;
    protected String description;
    private int[] pos;

    public Entity(String description){

        // Starts the player in bottom left corner
        this.pos = new int[]{-1,-1};

        this.description = description;
        this.health = 100;
        this.mana = 100;

        // Everybody needs some undies
        SkillAbility shiver = new RecoverManaAbility("Recovers 10 mana", 10, 0,0);
        Skill nothing = new Skill("Shiver");
        nothing.addAbility(shiver);
        Item undies = new Armor("Undies", nothing, 0, 2);

        this.equipItem(undies);
    }

    /**
     * @return String: entity description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return int[2]: current entity position on the board
     */
    public int[] getPos() {
        return pos;
    }

    /**
     * sets the entity's position on the board.
     * @param pos:int[2]: new player position
     */
    public void setPos(int[] pos) {
        this.pos = pos;
    }

    /**
     * sets the entity's position to (-1,-1) which is the starting point of all levels
     */
    public void resetPos(){
        this.setPos(new int[]{-1,-1});
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
     * Used to get the currently equipped item of the same type of the given item.
     * If there is not returns null
     * @param item: Item
     * @return Item
     */
    public Item getMatchingItem(Item item) {

        for (Item equippedItem: this.items) {
            if(equippedItem.getClass().equals(item.getClass())) {
                return equippedItem;
            }
        }

        return null;

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
     * Gives the enitity a choice to what item they want to keep, old or new
     *
     * @param newItem: Item
     */
    abstract public void promptSwap(Item newItem);

    public void setSwappingItem(Item swappingItem) {
        this.swappingItem = swappingItem;
    }

    public Item getSwappingItem() {
        return swappingItem;
    }

    /**
     * Used by graphics element to determine if an item is currently being swapped
     *
     * @return
     */
    public boolean isSwappingItem() {
        if(this.swappingItem == null) {
            return false;
        } else {
            return true;
        }
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
     * @return int: Entity's current health
     */
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

    /**
     * @return int: Entity's current mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * Subtracts a given amount of mana from an entity
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
    abstract public void battle(Entity opponent);

    /**
     * returns enemy
     * Note: This will be important for the Graphics to get the battle state
     *
     * @return Entity - the current enemy of this entity
     */
    public Entity getEnemy() {
        return enemy;
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
}
