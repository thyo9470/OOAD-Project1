package Factories;

import Items.*;
import Items.Skills.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Game.Game.getCurrentLevel;

public class ItemFactory {

    //create list of item names to be chosen from for random item selection
    private List<String> itemTypes = new ArrayList<String>();
    private List<String> skillTypes = new ArrayList<String>();

    public ItemFactory(){
        itemTypes.add("Armor");
        itemTypes.add("Helmet");
        itemTypes.add("MainHand");
        itemTypes.add("OffHand");
        skillTypes.add("DamageAbility");
        skillTypes.add("DrainManaAbility");
        skillTypes.add("HealAbility");
        skillTypes.add("RecoverManaAbility");
        skillTypes.add("BigDamageAbility");
        skillTypes.add("SelfDamageAbility");
        skillTypes.add("BigHeal");
        skillTypes.add("ManaSap");
        skillTypes.add("RegainFocus");
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
        else if(skillType == "BigDamageAbility"){
            return new DamageAbility("Massive 25 damage", 25, 40, 0);
        }
        else if(skillType == "SelfDamageAbility"){
            return new DamageAbility("20 damage at the cost of health", 20, 0, 10);
        }
        else if(skillType == "DrainManaAbility"){
            return new DrainManaAbility("Drain 20 mana", 20, 10, 0);
        }
        else if(skillType == "ManaSap"){
            return new DrainManaAbility("Sap a ton of mana at the cost of hp", 45, 0, 10);
        }
        else if(skillType == "HealAbility"){
            return new HealAbility("Heal 15 health", 15, 25, 0);
        }
        else if(skillType == "BigHeal"){
            return new HealAbility("A much stronger heal", 30, 40, 0);
        }
        else if(skillType == "RegainFocus"){
            return new RecoverManaAbility("Take damage to restore more mana", 35, 0, 10);
        }
        else{
            return new RecoverManaAbility("Recover 20 mana", 20, 0, 0);
        }
    }

    public Item createItem(){
        int level = getCurrentLevel();
        String type = chooseItemType();
        String skill = chooseSkillType();
        Skill newSkill = new Skill(String.format("%s's ability", type));
        newSkill.addAbility(makeSkill(skill));
        if(type.equals("Armor")){
            return new Armor("A protective breastplate", newSkill, 0, (int) (40*(level*0.5)));
        }
        else if(type == "Helmet"){
            return new Helmet("A mighty hat to sit upon the head", newSkill, (int) (10*(level*0.5)), (int) (30*(level*0.5)));
        }
        else if(type == "MainHand"){
            return new MainHand("A powerful weapon carried in the primary hand, the left of course", newSkill, (int) (40*(level*0.5)), (int) (0*(level*0.5)));
        }
        else{
            return new OffHand("A mystical artefact to be carried in the useless right hand", newSkill, (int) (30*(level*0.5)), (int) (10*(level*0.5)));
        }
    }

    public Item createNewItem(String type){
        int level = getCurrentLevel();
        String skill = chooseSkillType();
        Skill newSkill = new Skill(String.format("%s's ability", type));
        newSkill.addAbility(makeSkill(skill));
        if(type.equals("Armor")){
            return new Armor("A protective breastplate", newSkill, 0, (int) (40*(level*0.5)));
        }
        else if(type == "Helmet"){
            return new Helmet("A mighty hat to sit upon the head", newSkill, (int) (10*(level*0.5)), (int) (30*(level*0.5)));
        }
        else if(type == "MainHand"){
            return new MainHand("A powerful weapon carried in the primary hand, the left of course", newSkill, (int) (40*(level*0.5)), (int) (0*(level*0.5)));
        }
        else{
            return new OffHand("A mystical artefact to be carried in the useless right hand", newSkill, (int) (30*(level*0.5)), (int) (10*(level*0.5)));
        }
    }
}
