package jp.ac.uryukyu.ie.e245735;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {
    @Test
    void attackWithWeaponSkillTest() {
        int maximumHP = 100;
        int defaultAttack = 10;
        int defaultDamage = (int)(1.5*defaultAttack);
        for(int i=0; i<3; i++) {
            Warrior warrior = new Warrior("戦士", maximumHP, defaultAttack);
            Enemy enemy = new Enemy("スライム", maximumHP, 3);
            warrior.attackWithWeaponSkill(enemy);
            assertEquals(defaultDamage, maximumHP - enemy.getHitPoint());
        }
    }
}
