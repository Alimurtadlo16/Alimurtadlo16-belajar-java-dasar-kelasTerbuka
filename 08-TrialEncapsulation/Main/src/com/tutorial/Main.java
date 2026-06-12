package com.tutorial;
class Player{
    private final String name;
    private final int baseHealth;
    private final int baseAttack;
    private Armor armor;
    private Weapon weapon;
    private int level;
    private final int incrementAttack;


    public Player(String name){
        this.name = name;
        this.baseHealth = 100;
        this.baseAttack = 100;
        this.level = 1;
        this.incrementAttack = 20;
    }

    public void levelUp(){
        this.level++;
    }

    public void display(){
        System.out.println("Player\t\t: " + this.name);
        System.out.println("Level\t\t: " + this.level);
        System.out.println("MaxHealth\t: " + this.maxHealth());
        System.out.println("Attack\t: " + this.getAttack());
    }

    public void setArmor(Armor armor){
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public int maxHealth(){
        return this.baseHealth + this.armor.getStrength()*10;

    }

    public int getAttack(){
        return this.getAttackPower();
    }

    public int getAttackPower(){
        int weaponAttack = 0;

        if (this.weapon != null) {
            weaponAttack = this.weapon.getAttack();
        }

        return this.baseAttack + this.level*this.incrementAttack + weaponAttack;
    }
}

class Weapon{
    private final String name;
    private final int attack;

    public Weapon(String name, int attack){
        this.name = name;
        this.attack = attack;
    }

    public int getAttack(){
        return this.attack;
    }

    public String getName(){
        return this.name;
    }
}

class Armor{
    private final String name;
    private final int strength;
    private final int health;

    public Armor(String name, int strength, int health){
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public int getAddHealth(){
        return this.strength*10 + this.health;
    }

    public int getStrength(){
        return this.strength;
    }

    public String getName(){
        return this.name;
    }
}
public class Main{
    public static void main(String[] args){
        Player player1 = new Player("Ali");
        Armor armor1 = new Armor("baju Besi", 5,100);
        Weapon weapon1 = new Weapon("Pedang", 10);
        player1.setArmor(armor1);
        player1.setWeapon(weapon1);
        player1.display();
        player1.levelUp();
        player1.display();
        
        Player player2 = new Player("Murtadlo");
        Armor armor2 = new Armor("baju Baja", 5,100);
        Weapon weapon2 = new Weapon("Keris", 10);
        player2.setArmor(armor2);
        player2.setWeapon(weapon2);
        player2.display();
        player2.levelUp();
        player2.display();

    }
}