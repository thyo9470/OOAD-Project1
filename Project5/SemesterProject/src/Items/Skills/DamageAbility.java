package Items.Skills;

import Entities.Entity;

public class DamageAbility extends SkillAbility {

    private int damage;

    public DamageAbility(String description, int damage, int manaCost, int healthCost){
        super(description, manaCost, healthCost);
        this.damage = damage;
    }

    /**
     * Damages an opponent and applies cost to user
     *
     * @param user: Entity
     * @param opponent: Entity
     */
    @Override
    public void activate(Entity user, Entity opponent) {

        int totalDamage = this.damage * user.getAttack();
        opponent.damage(totalDamage);
        user.damage(this.healthCost);
        user.drainMana(this.manaCost);

    }
}
