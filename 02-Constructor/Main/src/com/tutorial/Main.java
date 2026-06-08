package com.tutorial;

// Make class non constructor
class Polosan{
    String dataString;
    int dataInt;
}
// Make class with constructor
class Mahasiswa{
    String nama;
    String NIM;
    String jurusan;
    String daerah;
    int umur;
    
    Mahasiswa(){
        System.out.println("Constructor Mahasiswa is called");
    }

    // Construstor with parameter
    Mahasiswa(String inputNama){
        nama = inputNama;
    }
    }

public class Main{
    public static void main(String[] args) throws Exception {
        Polosan objectPolosan = new Polosan();
        objectPolosan.dataString = "Hello World";
        objectPolosan.dataInt = 100;

        System.out.println(objectPolosan.dataString);
        System.out.println(objectPolosan.dataInt);
    
        Mahasiswa objectMahasiswa = new Mahasiswa();
        objectMahasiswa.nama = "Ali";
        objectMahasiswa.NIM = "123456789";
        objectMahasiswa.jurusan = "Teknik Informatika";
        objectMahasiswa.daerah = "Lamongan";
        objectMahasiswa.umur = 17;

        System.out.println(objectMahasiswa.nama);
        System.out.println(objectMahasiswa.NIM);
        System.out.println(objectMahasiswa.jurusan);
        System.out.println(objectMahasiswa.daerah);
        System.out.println(objectMahasiswa.umur);
    
        Mahasiswa mahasiswa2 = new Mahasiswa("Murtadlo");
        Mahasiswa mahasiswa3 = new Mahasiswa("Asadillah");

        System.out.println(mahasiswa2.nama);
        System.out.println(mahasiswa3.nama);
    }
}