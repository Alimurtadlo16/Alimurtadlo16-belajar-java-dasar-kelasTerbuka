package com.tutorial;

class Player {
    private String name;
    public int exp;

    Player(String name, int exp) {
        this.name = name;
        this.exp = exp;
    }

    void display(){
        tambahExp(50);
        System.out.println("\nName " + this.name);
        System.out.println("Exp " + this.exp);
    }

    public void ubahNama(String name) {
        this.name = name;
    }

    public void tambahExp(int tambah) {
        ubahExp(this.exp + tambah);
    }

    private void ubahExp(int exp) {
        this.exp = exp;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Ahmad", 100);
        System.out.println(player1.getName());
        player1.setName("Ali");
        System.out.println(player1.getName());

        System.out.println(player1.exp);
        player1.tambahExp(50);
        System.out.println(player1.exp);

        Player player2 = new Player("Murtadlo", 250);
        System.out.println(player2.getName());
        player2.setName("Asadillah");
        System.out.println(player2.getName());
    
        System.out.println(player2.exp);
        player2.tambahExp(50);
        System.out.println(player2.exp);

        player1.display();
        player2.display();
    

    }
}