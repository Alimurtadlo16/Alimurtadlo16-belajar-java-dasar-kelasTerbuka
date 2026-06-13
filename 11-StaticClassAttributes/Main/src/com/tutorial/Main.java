package com.tutorial;
class Display{
    static String type = "Display ";
    private final String name;

    Display(String name){
        this.name = name;
    }

    void setType(String typeInput){
        type = typeInput;
        this.type = typeInput;
        Display.type = typeInput;
    }

    void show(){
        System.out.println("Display name = " + this.name);
    }
}
public class Main{
    public static void main(String[] args){
        Display display1 = new Display("Monitor");
        display1.show();
        
        Display display2 = new Display("Smartphone");
        display2.show();

        // Show static variable
        // Change static variable
        display1.setType("Monitor");

        System.out.println("\nMenampilkan static class variable");
        System.out.println(display1.type);
        System.out.println(display2.type);
        System.out.println(Display.type);
        
    }
}