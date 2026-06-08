package com.tutorial;

public class Mahasiswa {
    String nama;
    String NIM;
    String jurusan;

    public Mahasiswa(String nama, String NIM, String jurusan) {
        this.nama = nama;
        this.NIM = NIM;
        this.jurusan = jurusan;
    }

    // Method tanpa return dan parameter
    void show() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + NIM);
        System.out.println("Jurusan: " + jurusan);
    }

    // Method tanpa return dan dengan parameter
    void setNama(String nama) {
        this.nama = nama;
    }

    // Method dengan return dan tanpa parameter
    String getNama() {
        return nama;
    }

    String getNIM() {
        return NIM;
    }

    // Method dengan return dan parameter
    String sayHi(String message) {
        return message + " juga, nama saya adalah " + this.nama;
    }
}
