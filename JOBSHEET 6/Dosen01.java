public class Dosen01 {

    String kode;
    String nama;
    boolean jenisKelamin; 
    int usia;

    Dosen01(String kd, String name, boolean jk, int umur) {
        kode         = kd;
        nama         = name;
        jenisKelamin = jk;
        usia         = umur;
    }

    void tampil() {
        System.out.println("Kode  : " + kode);
        System.out.println("Nama  : " + nama);
        System.out.println("JK    : " + jenisKelamin);
        System.out.println("Usia  : " + usia);
    }
}
