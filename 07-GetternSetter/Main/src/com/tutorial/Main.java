package com.tutorial;
class Data{
    public int intPublic;
    private final int intPrivate;
    private double doublePrivate;

    public Data(){
        this.intPublic = 0;
        this.intPrivate = 0;
    }

    // Getter
    public int getIntPrivate() {
        return this.intPrivate;
    }

    void display(){
        System.out.println(this.intPublic);
        System.out.println(this.intPrivate);
        System.out.println(this.doublePrivate);
    }

    // Setter
    public void setDoublePrivate(double value){
        this.doublePrivate = value;
    }

    // Getter
    public double getJari2(){
        return this.doublePrivate; // Assuming this is the intended return value
    }
}

class Lingkaran{
    private double diameter;

    Lingkaran(double diameter){
        this.diameter = diameter;
    }

    // Setter
    public void setJari2(double jari2){
        this.diameter = jari2*2;
    }

    // Getter
    public double getDiameter(){
        return this.diameter;
    }

    // Getter
    public double getJari2(){
        return this.diameter/2;
    }

    // Getter
    public double getLuas(){
        return 3.14*diameter*diameter/4;
    }
}

public class Main {
    public static void main(String[] args) {
        Data object = new Data();

        // Sample public read n write
        object.intPublic = 10;
        System.out.println("public : " + object.intPublic);

        // Read only with getter
        int angka = object.getIntPrivate();
        System.out.println("getter  : " + angka);

        object.setDoublePrivate(0.05);
        object.display();

        Lingkaran lingkaran = new Lingkaran(7);
        System.out.println("diameter: " + lingkaran.getDiameter());
        lingkaran.setJari2(10);
        System.out.println("diameter: " + lingkaran.getDiameter());

        // read n Write with Setter n Getter
        Lingkaran object2 = new Lingkaran(5);
        System.out.println("jari - jari : " + object2.getJari2());
        object2.setJari2(14);
        System.out.println("jari - jari : " + object2.getJari2());
        System.out.println("luas : " + object2.getLuas());

    }
}