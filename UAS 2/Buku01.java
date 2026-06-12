public class Buku01 {
    String kodeBuku;
    String judul;
    String penulis;
    int tahunTerbit;

     // Konstruktor untuk mengisi data buku
    public Buku01(String kodeBuku, String judul, String penulis, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Menampilkan informasi buku
    public void tampilInformasi() {
        System.out.println("Kode Buku   : " + kodeBuku);
        System.out.println("Judul       : " + judul);
        System.out.println("Penulis     : " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println();
    }
}
  
