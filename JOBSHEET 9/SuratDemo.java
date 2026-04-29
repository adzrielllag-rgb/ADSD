package jobsheet9;

import java.util.Scanner;

public class SuratDemo {
  
  public static void main(String[] args) {
        StackSurat01 stack = new StackSurat01(10);
        Scanner scan = new Scanner(System.in);
        int pilih;
        int counter = 1; 

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    String idSurat = "SRT" + String.format("%03d", counter++);
                    System.out.print("Nama Mahasiswa: ");
                    String nama = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S=Sakit / I=Izin): ");
                    char jenisIzin = scan.nextLine().toUpperCase().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    Surat01 surat = new Surat01(idSurat, nama, kelas, jenisIzin, durasi);
                    stack.push(surat);
                    System.out.printf("Surat izin dari %s berhasil diterima. ID: %s\n", nama, idSurat);
                    break;

                case 2:
                    Surat01 diproses = stack.pop();
                    if (diproses != null) {
                        String jenis = (diproses.jenisIzin == 'S') ? "Sakit" : "Izin Keperluan Lain";
                        System.out.println("=== Memproses Surat ===");
                        System.out.println("ID Surat      : " + diproses.idSurat);
                        System.out.println("Nama          : " + diproses.namaMahasiswa);
                        System.out.println("Kelas         : " + diproses.kelas);
                        System.out.println("Jenis Izin    : " + jenis);
                        System.out.println("Durasi        : " + diproses.durasi + " hari");
                        System.out.println("Status        : DITERIMA");
                    }
                    break;

                case 3:
                    Surat01 teratas = stack.peek();
                    if (teratas != null) {
                        String jenis = (teratas.jenisIzin == 'S') ? "Sakit" : "Izin ";
                        System.out.println("=== Surat Izin Terakhir ===");
                        System.out.println("ID Surat      : " + teratas.idSurat);
                        System.out.println("Nama          : " + teratas.namaMahasiswa);
                        System.out.println("Kelas         : " + teratas.kelas);
                        System.out.println("Jenis Izin    : " + jenis);
                        System.out.println("Durasi        : " + teratas.durasi + " hari");
                    }
                    break;

                case 4:
                    System.out.print("Nama mahasiswa yang dicari: ");
                    String cari = scan.nextLine();
                    boolean menemukan = stack.cariSurat(cari);
                    if (menemukan) {
                        System.out.println("Surat izin atas nama \"" + cari + "\" DITEMUKAN ");
                    } else {
                        System.out.println("Surat izin atas nama \"" + cari + "\" TIDAK DITEMUKAN.");
                    }
                    break;

                case 5:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("tidak ada pilihan tersebut!");
            }
        } while (pilih >= 1 && pilih <= 4);

        scan.close();
    }
}
