package Items.Skills;

import Entities.Entity;

/**
 * STRATEGY PATTERN
 * Acts as the strategy for strategy pattern
 * Creates overall design for skill ability strategies
 */
abstract public class SkillAbility {

   private String description;
   protected int manaCost;
   protected int healthCost;

   public SkillAbility(String description, int manaCost, int healthCost){
      this.description = description;
      this.manaCost = manaCost;
      this.healthCost = healthCost;
   }

   public String getDescription() {
      return description;
   }

   public int getManaCost() {
      return manaCost;
   }

   public int getHealthCost() {
      return healthCost;
   }

   abstract public void activate(Entity user, Entity opponent);
}
