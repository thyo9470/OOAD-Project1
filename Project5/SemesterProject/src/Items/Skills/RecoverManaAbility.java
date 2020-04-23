package Items.Skills;

import Entities.Entity;

public class RecoverManaAbility extends SkillAbility{

    private int manaAmount;

    public RecoverManaAbility(String description, int manaAmount, int manaCost, int healthCost){
        super(description, manaCost, healthCost);
        this.manaAmount = manaAmount;
    }

    /**
     * recovers a user's mana and applies cost to user
     *
     * @param user: Entity
     * @param opponent: Entity
     */
    @Override
    public void activate(Entity user, Entity opponent) {

        user.drainMana(-this.manaAmount);
        user.damage(this.healthCost);
        user.damage(this.manaCost);

    }
}
