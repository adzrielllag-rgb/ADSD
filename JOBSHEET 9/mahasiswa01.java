package jobsheet9;

public class mahasiswa01 {
    String nim;
    String nama;
    String kelas;
    int nilai;

    // Konstruktor default
    public mahasiswa01() {}

    // Konstruktor berparameter
    public mahasiswa01(String nama, String nim, String kelas) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.nilai = -1; // nilai default sebelum dinilai
    }

    // Method untuk mengeset nilai tugas
    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }  
}
