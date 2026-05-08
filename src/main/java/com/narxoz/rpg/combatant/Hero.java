package com.narxoz.rpg.combatant;

public class Hero {
    private String name;
    private int health;
    private int attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " (❤️ " + health + ", ⚔️ " + attackPower + ")";
    }
}