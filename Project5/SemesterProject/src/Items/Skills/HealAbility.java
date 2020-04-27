package Items.Skills;

import Entities.Entity;

public class HealAbility extends SkillAbility {

    private int healAmount;

    public HealAbility(String description, int healAmount, int manaCost, int healthcost){
        super(description, manaCost, healthcost);
        this.healAmount = healAmount;
    }

    /**
     * heals user and applies cost to user
     *
     * @param user: Entity
     * @param opponent: Entity
     */
    @Override
    public void activate(Entity user, Entity opponent) {

        user.damage(-this.healAmount);
        user.damage(this.healthCost);
        user.drainMana(this.manaCost);

    }
}
