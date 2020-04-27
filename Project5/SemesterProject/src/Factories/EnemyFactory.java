package Factories;

import Entities.Enemy;
import Items.Item;
import Items.MainHand;
import Items.Skills.DamageAbility;
import Items.Skills.Skill;

public class EnemyFactory {

    private EnemyFactory factory;

    public EnemyFactory(EnemyFactory factory){
        this.factory = factory;
    }

    public Enemy createEnemy(){

        //Todo: add item variety for enemies
        Enemy enemy = new Enemy("enemy");
        Skill knifeSkill = new Skill("stab");
        DamageAbility damageAbility = new DamageAbility("10 base damage", 10, 20, 0);
        knifeSkill.addAbility(damageAbility);
        Item knife = new MainHand("knife", knifeSkill);
        enemy.setRewardItem(knife);
        return enemy;
    }
}
