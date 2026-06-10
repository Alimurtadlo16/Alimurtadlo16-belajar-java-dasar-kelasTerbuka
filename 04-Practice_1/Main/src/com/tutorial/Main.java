package com.tutorial;

class Player {
    String name;
    double health;
    int level;

    Weapon weapon;
    Armor armor;

    Player(String name, double health) {
        this.name = name;
        this.health = health;
    }

    void attack(Player opponent) {
        System.out.println(this.name + " attacks " + opponent.name);
        double attackPower = (this.weapon != null ? this.weapon.attackPower : 0) + (this.level * 10);
        System.out.println("Attack Power: " + this.name + " with power " + attackPower);
        opponent.defense(this, attackPower);
    }

    void defense(Player opponent, double attackPower) {
        System.out.println(this.name + " defends against " + opponent.name);

        double defensePower = (this.armor != null ? this.armor.defensePower : 0) + (this.level * 5);
        double damage = attackPower > defensePower ? attackPower - defensePower : 0;

        this.health -= damage;
        System.out.println(this.name + " takes damage: " + damage + ", remaining health: " + this.health);
    }

    void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    void equipArmor(Armor armor) {
        this.armor = armor;
    }

    void display() {
        System.out.println("Player Name: " + this.name + ", Level: " + this.level + ", Health: " + this.health + " hp");
        if (this.weapon != null) {
            this.weapon.display();
        }
        if (this.armor != null) {
            this.armor.display();
        }
    }
}

class Weapon {
    double attackPower;
    String name;

    Weapon(double attackPower) {
        this.attackPower = attackPower;
    }

    void display() {
        System.out.println("Weapon Name: " + this.name + ", Attack Power: " + this.attackPower);
    }
}

class Armor {
    double defensePower;

    Armor(double defensePower) {
        this.defensePower = defensePower;
    }

    void display() {
        System.out.println("Armor Defense Power: " + this.defensePower);
    }
}

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Ali", 1000);
        player1.level = 1;

        Player player2 = new Player("Murtadlo", 550);
        player2.level = 2;

        Weapon Pedang = new Weapon(300);
        Pedang.name = "Pedang";

        Weapon Kapak = new Weapon(250);
        Kapak.name = "Kapak";

        Armor BajuBesi = new Armor(150);
        Armor BajuBaja = new Armor(200);

        player1.equipWeapon(Pedang);
        player1.equipArmor(BajuBesi);
        player1.display();

        player2.equipWeapon(Kapak);
        player2.equipArmor(BajuBaja);
        player2.display();

        System.out.println("Battle Start!");
        System.out.println("\nRound 1:");
        player1.attack(player2);
        player1.display();
        player2.display();
        System.out.println("\nRound 2:");
        player2.attack(player1);
        player1.display();
        player2.display();
    }
}