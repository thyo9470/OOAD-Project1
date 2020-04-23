package Factories;

import Items.*;
import Items.Skills.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {

    //create list of item names to be chosen from for random item selection
    private List<String> itemTypes = new ArrayList<String>();
    private List<String> skillTypes = new ArrayList<String>();

    public ItemFactory(ItemFactory factory){
        itemTypes.add("Armor");
        itemTypes.add("Helmet");
        itemTypes.add("MainHand");
        itemTypes.add("OffHand");
        skillTypes.add("DamageAbility");
        skillTypes.add("DrainManaAbility");
        skillTypes.add("HealAbility");
        skillTypes.add("RecoverManaAbility");
    }

    private String chooseItemType(){

        Random rand = new Random();
        return itemTypes.get(rand.nextInt(itemTypes.size()));
    }

    private String chooseSkillType(){

        Random rand = new Random();
        return skillTypes.get(rand.nextInt(skillTypes.size()));
    }

    private SkillAbility makeSkill(String skillType){
        if(skillType == "DamageAbility"){
            return new DamageAbility("Base 10 damage",10,20,0);
        }
        else if(skillType == "DrainManaAbility"){
            return new DrainManaAbility("Drain 20 mana", 20, 0, 10);
        }
        else if(skillType == "HealAbility"){
            return new HealAbility("Heal 15 health", 15, 25, 0);
        }
        else{
            return new RecoverManaAbility("Recover 20 mana", 20, 0, 0);
        }
    }

    public Item createItem(){
        String type = chooseItemType();
        String skill = chooseSkillType();
        Skill newSkill = new Skill(String.format("%s's ability", type));
        newSkill.addAbility(makeSkill(skill));
        if(type == "Armor"){
            return new Armor("A protective breastplate", newSkill);
        }
        else if(type == "Helmet"){
            return new Helmet("A mighty hat to sit upon the head", newSkill);
        }
        else if(type == "MainHand"){
            return new MainHand("A powerful weapon carried in the primary hand, the left of course", newSkill);
        }
        else{
            return new OffHand("A mystical artefact to be carried in the useless right hand", newSkill);
        }
    }
}
