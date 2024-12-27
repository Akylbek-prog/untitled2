package src.kg.geeks.game.players;

import src.kg.geeks.game.general.RPG_Game;

public class Ludoman extends Hero {
    public Ludoman(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.GAMBLE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = RPG_Game.random.nextInt(6) + 1;
        int dice2 = RPG_Game.random.nextInt(6) + 1;

        if (dice1 == dice2) {
            int damageToBoss = dice1 * dice2;
            boss.setHealth(boss.getHealth() - damageToBoss);
            System.out.println("Ludoman " + super.getName() + " dealt " + damageToBoss + " damage to the Boss by matching dice!");
        } else {
            int damageToAlly = dice1 + dice2;
            Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            while (randomHero == this || randomHero.getHealth() <= 0) {
                randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            }
            randomHero.setHealth(randomHero.getHealth() - damageToAlly);
            System.out.println("Ludoman " + super.getName() + " dealt " + damageToAlly + " damage to " + randomHero.getName() + " due to mismatched dice.");
        }
    }
}
