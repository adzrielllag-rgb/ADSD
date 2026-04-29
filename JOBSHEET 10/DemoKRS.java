import java.util.Scanner;

public class DemoKRS {
    public static void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEM ANTRIAN PERSETUJUAN KRS DPA   ");
        System.out.println("========================================");
        System.out.println("1.  Tambah Mahasiswa ke Antrian");
        System.out.println("2.  Panggil Antrian KRS (2 mahasiswa)");
        System.out.println("3.  Tampilkan Semua Antrian");
        System.out.println("4.  Tampilkan 2 Antrian Terdepan");
        System.out.println("5.  Tampilkan Antrian Paling Akhir");
        System.out.println("6.  Cek Antrian Kosong");
        System.out.println("7.  Cek Antrian Penuh");
        System.out.println("8.  Kosongkan Antrian");
        System.out.println("9.  Jumlah Antrian Saat Ini");
        System.out.println("10. Jumlah Mahasiswa Sudah KRS");
        System.out.println("11. Jumlah Mahasiswa yang mengantri KRS");
        System.out.println("0.  Keluar");
        System.out.println("----------------------------------------");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Kapasitas antrian maksimal 10, DPA maksimal layani 30
        AntrianKRS antrian = new AntrianKRS(10);

        System.out.println("== Sistem Antrian KRS ==");
        System.out.println("Kapasitas antrian: 10 mahasiswa");
        System.out.println("Batas layanan DPA : 30 mahasiswa");

        int pilihan;

        do {
            tampilkanMenu();
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    MhsKRS mhs = new MhsKRS(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;

                case 2:
                    antrian.panggilAntrian();
                    break;

                case 3:
                    antrian.tampilkanSemua();
                    break;

                case 4:
                    antrian.tampilkan2Terdepan();
                    break;

                case 5:
                    antrian.lihatAkhir();
                    break;

                case 6:
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian KOSONG.");
                    } else {
                        System.out.println("Antrian BELUM kosong. Jumlah: " + antrian.getJumlahAntrian());
                    }
                    break;

                case 7:
                    if (antrian.isFull()) {
                        System.out.println("Antrian PENUH (kapasitas: " + 10 + ").");
                    } else {
                        System.out.println("Antrian BELUM penuh.Sisa: " + (10 - antrian.getJumlahAntrian()));
                    }
                    break;

                case 8:
                    antrian.kosongkanAntrian();
                    break;

                case 9:
                    System.out.println("Jumlah mahasiswa dalam antrian saat ini: " + antrian.getJumlahAntrian());
                    break;

                case 10:
                    System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + antrian.getSudahKRS());
                    break;

                case 11:
                    System.out.println("Jumlah mahasiswa yang masih mengantri: " + antrian.getBelumKRS());
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan Sistem Antrian KRS.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }
  
}
