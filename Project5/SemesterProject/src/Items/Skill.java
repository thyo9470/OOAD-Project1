package Items;

import Entities.Entity;

public class Skill {

    private String description;
    private boolean targetOpponent;
    private int damage;
    private int manaDrain;

    public Skill(String description, boolean targetOpponent, int damage, int manaDrain) {
        this.description = description;
        this.targetOpponent = targetOpponent;
        this.damage = damage;
        this.manaDrain = manaDrain;
    }

    public String getDescription() {
        return description;
    }

    /**
     *  A given users activates a skill on a target.
     *  Currently this action can:
     *   - affect entity health
     *   - affect entity mana
     *
     * @param user - The entity using the skill is used to determine strength of skill
     * @param opponent - The opponent for when the skill targets opponent
     */
    public void activate(Entity user, Entity opponent) {

        if(this.targetOpponent)  {
            int totalDamage = this.damage * user.getAttack();
            opponent.damage(totalDamage);
            opponent.drainMana(this.manaDrain);
        } else {
            user.damage(this.damage);
            user.drainMana(this.manaDrain);
        }

    }

}
