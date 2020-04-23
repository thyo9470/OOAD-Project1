package Items.Skills;

import Entities.Entity;

public class DrainManaAbility extends SkillAbility {

    private int manaAmount;

    public DrainManaAbility(String description, int manaAmount, int manaCost, int healthCost){
        super(description, manaCost, healthCost);
        this.manaAmount = manaAmount;
    }

    /**
     * Drains mana from an opponent and applies cost to user
     *
     * @param user: Entity
     * @param opponent: Entity
     */
    @Override
    public void activate(Entity user, Entity opponent) {

        opponent.drainMana(this.manaAmount);
        user.damage(this.healthCost);
        user.damage(this.manaCost);

    }
}
