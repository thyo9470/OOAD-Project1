package Items.Skills;

import Entities.Entity;

import java.util.ArrayList;

// TODO: Make into Strategy Pattern
public class Skill {

    private String description;
    private ArrayList<SkillAbility> skillAbilities;

    public Skill(String description) {
        this.description = description;
        this.skillAbilities = new ArrayList<>();
    }

    public void addAbility(SkillAbility ability){
        this.skillAbilities.add(ability);
    }

    public ArrayList<SkillAbility> getSkillAbilities() {
        return skillAbilities;
    }

    public void removeAbility(SkillAbility ability){
        this.skillAbilities.remove(ability);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {

        String fullDescription = "<b>" + this.description + "</b><br>";

        for (SkillAbility ability:this.skillAbilities) {
            fullDescription += "<br>" + ability.getClass().getSimpleName() + ": " + ability.getDescription();
        }

        fullDescription = "<html>" + fullDescription + "</html>";

        return fullDescription;

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

        for (SkillAbility ability: this.skillAbilities) {
            ability.activate(user, opponent);
        }

    }

    /**
     * Gets total mana cost from all abilities
     *
     * @return int
     */
    public int getManaCost() {

        int manaCost = 0;

        for (SkillAbility ability:this.skillAbilities) {
           manaCost += ability.getManaCost();
        }

        return manaCost;
    }

    /**
     * Gets total health cost from all abilities
     *
     * @return int
     */
    public int getHealthCost() {

       int healthCost = 0;

        for (SkillAbility ability: this.skillAbilities) {
           healthCost += ability.getHealthCost();
        }

        return healthCost;
    }

}
