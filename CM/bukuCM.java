package CM;
public class bukuCM {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    bukuCM(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    void tampilBuku() {
        System.out.println("Kode: " + kodeBuku + 
                    " | Judul: " + judul + 
                    " | Tahun: " + tahunTerbit);
    }
}
