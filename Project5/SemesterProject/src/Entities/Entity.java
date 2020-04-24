package Entities;

import Graphics.GraphicsHandler;
import Items.*;
import Interactions.Interactable;
import Items.Skills.DamageAbility;
import Items.Skills.RecoverManaAbility;
import Items.Skills.Skill;

import java.util.ArrayList;

public abstract class Entity extends Interactable {

    private int health;
    private int mana;
    private ArrayList<Item> items = new ArrayList<>();
    protected Item swappingItem;
    protected Entity enemy;
    protected String description;

    // TODO: Delete when done testing
    public static void main(String[] args) {

        // create Player
        Interactable player = new Player("player");
        Skill hatSkill = new Skill("Sit on head");
        RecoverManaAbility recoverManaAbility = new RecoverManaAbility("Recover 20 mana", 20, 0, 0);
        hatSkill.addAbility(recoverManaAbility);
        Item hat = new Helmet("hat", hatSkill);
        ((Entity)player).equipItem(hat);

        // equip main hand item
        Skill swordSkill = new Skill("stab");
        DamageAbility damageAbility = new DamageAbility("10 base damage", 10, 20, 0);
        swordSkill.addAbility(damageAbility);
        Item sword = new MainHand("Sword", swordSkill);
        ((Entity)player).equipItem(sword);


        Interactable enemy = new Enemy("enemy");
        Skill knifeSkill = new Skill("stab");
        knifeSkill.addAbility(damageAbility);
        Item knife = new MainHand("knife", knifeSkill);
        ((Enemy)enemy).setRewardItem(knife);


        GraphicsHandler graphicsHandler = new GraphicsHandler();
        graphicsHandler.setInteractable(player);
        player.registerObserver(graphicsHandler);

        ((Entity) player).battle((Entity) enemy);

    }

    public Entity(String description){
        this.description = description;
        this.health = 100;
        this.mana = 100;

        // Everything spawns with at least undies
        Skill nothing = new Skill("Shiver");
        Item undies = new Armor("Undies", nothing);

        this.equipItem(undies);
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
    // TODO: Use this for floor display and format to be in HTML
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
        System.out.println("Draining mana: " + Integer.toString(amount));
        this.mana -= amount;
    }

    /**
     * Has entity take their turn in a battle
     *
     * @param opponent - who the entity is fighting
     */
    abstract public void battle(Entity opponent);

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
}
