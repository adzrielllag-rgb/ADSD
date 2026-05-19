import java.util.Scanner;
public class Main {

   // ===== TAMPILKAN MENU UTAMA =====
    static void tampilkanMenu() {
        System.out.println("\n==============================");
        System.out.println("  SISTEM ANTRIAN ROYAL DELISH");
        System.out.println("==============================");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Total Pembeli");
        System.out.println("3. Hapus Antrian dan Pesan");
        System.out.println("4. Laporan Pesanan");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu : ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianDLL antrian = new AntrianDLL();
        PesananDLL pesanan = new PesananDLL();

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = Integer.parseInt(sc.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String noHp = sc.nextLine();
                    antrian.tambahAntrian(nama, noHp);
                    break;

                case 2:

                // MODIF KUIZ: Tampilkan total pembeli dalam antrian
                    antrian.totalPembeli();
                    break;

                case 3:
                    antrian.hapusAntrian(pesanan, sc);
                    break;

                case 4:
                    pesanan.laporanPesanan();
                    break;

                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }

        } while (pilihan != 0);

        sc.close();
    }
}
