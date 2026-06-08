package com.tutorial;

public class Main {
    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa("Ali", "123456", "Informatika");
        System.out.println(mahasiswa1.nama);
        test();
    
        mahasiswa1.show();
        mahasiswa1.setNama("Murtadlo");
        mahasiswa1.show();
    
        System.out.println(mahasiswa1.getNama());
        System.out.println(mahasiswa1.getNIM());

        String data = mahasiswa1.sayHi("Halo");
        System.out.println(data);
    
    }

    static void test(){
        System.out.println("Ini adalah method test");
    }
}
