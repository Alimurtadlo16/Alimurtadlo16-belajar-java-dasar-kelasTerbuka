package com.tutorial;
// Make class template
class Mahasiswa{
    String nama;
    String jurusan;
    String nim;
    String daerah;
    double ipk;
    int umur;
}
public class Main {
    public static void main(String[] args) throws Exception {
        Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.nama = "Ali";
        mahasiswa1.jurusan = "Teknik Informatika";
        mahasiswa1.nim = "123456789";
        mahasiswa1.ipk = 4.0;
        mahasiswa1.umur = 17;
        mahasiswa1.daerah = "Lamongan";

        System.out.println(mahasiswa1.nama);
        System.out.println(mahasiswa1.jurusan);
        System.out.println(mahasiswa1.nim);
        System.out.println(mahasiswa1.ipk);
        System.out.println(mahasiswa1.umur);
    
        System.out.println(mahasiswa1.daerah);

    }
}