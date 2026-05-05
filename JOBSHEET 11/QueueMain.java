import java.util.Scanner;

public class QueueMain {
  
  static Scanner sc = new Scanner(System.in);
  static QueueLinkedList antrian = new QueueLinkedList(10); // maks 10 orang
  static void tampilMenu() {
      System.out.println("--------------------------------------------");
      System.out.println("  [1] Daftar Antrian");
      System.out.println("  [2] Panggil Antrian (Dequeue)");
      System.out.println("  [3] Tampilkan Semua Antrian");
      System.out.println("  [4] Lihat Antrian Terdepan");
      System.out.println("  [5] Lihat Antrian Paling Akhir");
      System.out.println("  [6] Jumlah Mahasiswa Mengantri");
      System.out.println("  [7] Cek Status Antrian (Kosong/Penuh)");
      System.out.println("  [8] Kosongkan Antrian");
      System.out.println("  [0] Keluar");
      System.out.println("--------------------------------------------");
  }
  
  static void daftarAntrian() {
      if (antrian.isFull()) {
          System.out.println("  [!] Antrian penuh! Tidak dapat mendaftar.");
          return;
      }
      System.out.println("  -- Form Pendaftaran Antrian --");
      System.out.print("  NIM       : ");
      String nim = sc.nextLine();
      System.out.print("  Nama      : ");
      String nama = sc.nextLine();
      System.out.print("  Keperluan : ");
      String keperluan = sc.nextLine();
  
      MahasiswaQueue01 mhs = new MahasiswaQueue01(nim, nama, keperluan);
      antrian.enqueue01(mhs);
  }
  
  static void cekStatus() {
      if (antrian.isEmpty()) {
          System.out.println("  Status: ANTRIAN KOSONG");
      } else if (antrian.isFull()) {
          System.out.println("  Status: ANTRIAN PENUH");
      } else {
          System.out.println("  Status: Antrian tersedia (tidak kosong, tidak penuh)");
      }
  }

    public static void main(String[] args) {
        int pilihan;

        System.out.println("============================================");
        System.out.println("   SISTEM ANTRIAN UNIT KEMAHASISWAAN        ");
        System.out.println("============================================");

        do {
            tampilMenu();
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // flush newline
            System.out.println();

            switch (pilihan) {
                case 1:
                    daftarAntrian();
                    break;
                case 2:
                    antrian.dequeue();
                    break;
                case 3:
                    antrian.tampilAntrian();
                    break;
                case 4:
                    antrian.peekFront();
                    break;
                case 5:
                    antrian.peekRear();
                    break;
                case 6:
                    antrian.jumlahAntrian();
                    break;
                case 7:
                    cekStatus();
                    break;
                case 8: {
                    System.out.print("  Yakin ingin mengosongkan antrian? (y/n): ");
                    String konfirmasi = sc.nextLine();
                    if (konfirmasi.equalsIgnoreCase("y")) antrian.clear();
                    break;
                }
                case 0:
                    System.out.println("  Terima kasih. Sistem ditutup.");
                    break;
                default:
                    System.out.println("  [!] Menu tidak valid.");
                    break;
            }
            System.out.println();

        } while (pilihan != 0);
    }

}
