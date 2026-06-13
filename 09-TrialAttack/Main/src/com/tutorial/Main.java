package com.tutorial;

class Player {
    private final String name;
    private final int baseHealth;
    private final int baseAttack;
    private Armor armor;
    private Weapon weapon;
    private int level;
    private final int incrementAttack;
    private int currentHealth; 

    public Player(String name){
        this.name = name;
        this.baseHealth = 100;
        this.baseAttack = 100;
        this.level = 1;
        this.incrementAttack = 20;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    // Mengecek apakah player masih hidup
    public boolean isAlive() {
        return this.currentHealth > 0;
    }

    public void levelUp(){
        this.level++;
        this.currentHealth = this.maxHealth(); 
    }

    public void initHealth() {
        this.currentHealth = this.maxHealth();
    }

    public void display(){
        System.out.println("Player\t\t: " + this.name);
        System.out.println("Level\t\t: " + this.level);
        System.out.println("Health\t\t: " + this.currentHealth + "/" + this.maxHealth());
        System.out.println("Attack\t\t: " + this.getAttack());
        System.out.println("---------------------------------");
    }

    public void setArmor(Armor armor){
        this.armor = armor;
        initHealth(); 
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public int maxHealth(){
        if (this.armor != null) {
            return this.baseHealth + this.armor.getAddHealth();
        }
        return this.baseHealth;
    }

    public int getAttack(){
        return this.getAttackPower();
    }

    public int getAttackPower(){
        int weaponAttack = 0;
        if (this.weapon != null) {
            weaponAttack = this.weapon.getAttack();
        }
        return this.baseAttack + this.level * this.incrementAttack + weaponAttack;
    }

    // Method menyerang musuh
    public void attack(Player enemy) {
        int damageDealt = this.getAttack();
        System.out.println("⚔️ [" + this.name + "] menyerang [" + enemy.getName() + "] sebesar " + damageDealt + " DMG!");
        enemy.takeDamage(damageDealt);
    }

    // Method menerima damage
    public void takeDamage(int damage) {
        int defense = 0;
        if (this.armor != null) {
            defense = this.armor.getStrength() * 5; 
        }

        int netDamage = damage - defense;
        if (netDamage < 1) netDamage = 1; 

        this.currentHealth -= netDamage;
        if (this.currentHealth < 0) this.currentHealth = 0;

        System.out.println("🛡️ [" + this.name + "] menahan serangan (Defense: " + defense + "). Sisa HP: " + this.currentHealth);
    }
}

class Weapon {
    private final String name;
    private final int attack;

    public Weapon(String name, int attack){
        this.name = name;
        this.attack = attack;
    }

    public int getAttack(){
        return this.attack;
    }
}

class Armor {
    private final String name;
    private final int strength;
    private final int health;

    public Armor(String name, int strength, int health){
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public int getAddHealth(){
        return this.strength * 10 + this.health;
    }

    public int getStrength(){
        return this.strength;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Setup Player 1
        Player player1 = new Player("Ali");
        Armor armor1 = new Armor("Baju Besi", 5, 100);
        Weapon weapon1 = new Weapon("Pedang", 25); // Menaikkan attack agar match cepat selesai
        player1.setArmor(armor1);
        player1.setWeapon(weapon1);
        
        // Setup Player 2
        Player player2 = new Player("Murtadlo");
        Armor armor2 = new Armor("Baju Baja", 5, 80);
        Weapon weapon2 = new Weapon("Keris", 30);
        player2.setArmor(armor2);
        player2.setWeapon(weapon2);

        System.out.println("=== KONDISI AWAL PETARUNG ===");
        player1.display();
        player2.display();

        System.out.println("\n🔥 PERTANDINGAN DIMULAI 🔥\n");
        int ronde = 1;

        // Loop berjalan secara real-time sampai salah satu Player mati (isAlive() = false)
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("--- RONDE " + ronde + " ---");
            
            // Player 1 menyerang Player 2
            player1.attack(player2);
            System.out.println();
            
            // Jeda waktu 1 detik agar terasa real-time mengalir
            Thread.sleep(1000); 

            // Cek apakah Player 2 sudah mati setelah diserang Player 1
            if (!player2.isAlive()) {
                break; // Keluar dari loop jika Player 2 mati
            }

            // Player 2 membalas menyerang Player 1
            player2.attack(player1);
            System.out.println();
            
            // Jeda waktu 1 detik lagi sebelum masuk ronde berikutnya
            Thread.sleep(1000);

            ronde++;
        }

        // DEKLARASI PEMENANG //
        System.out.println("=================================");
        System.out.println("💥 PERTANDINGAN BERAKHIR! 💥");
        System.out.println("=================================");
        
        if (player1.isAlive()) {
            System.out.println("🏆 PEMENANGNYA ADALAH: [" + player1.getName() + "] 🎉");
        } else {
            System.out.println("🏆 PEMENANGNYA ADALAH: [" + player2.getName() + "] 🎉");
        }
        
        System.out.println("\n=== STATUS AKHIR ===");
        player1.display();
        player2.display();
    }
}