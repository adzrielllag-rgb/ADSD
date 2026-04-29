
package jobsheet6;

public class Mahasiswa01 {
    String nim, nama, kelas;
    double ipk;

    Mahasiswa01() {}

    Mahasiswa01(String nm, String name, String kls, double ip) {
        nim  = nm;
        nama = name;
        ipk  = ip;
        kelas = kls;
    }

    void tampilInformasi() {
        System.out.println("Nama: "  + nama);
        System.out.println("NIM: "   + nim);
        System.out.println("IPK: "   + ipk);
        System.out.println("Kelas: " + kelas);
    }
}
