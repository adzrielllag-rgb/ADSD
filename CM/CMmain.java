package CM;
import java.util.Scanner;

public class CMmain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // ===== DATA MAHASISWA =====
        mahasiswaCM[] mahasiswa = {
            new mahasiswaCM("22001", "Andi", "Teknik Informatika"),
            new mahasiswaCM("22002", "Budi", "Teknik Informatika"),
            new mahasiswaCM("22003", "Citra", "Sistem Informasi Bisnis")
        };

        // ===== DATA BUKU =====
        bukuCM[] buku = {
            new bukuCM("B001", "Algoritma", 2020),
            new bukuCM("B002", "Basis Data", 2019),
            new bukuCM("B003", "Pemrograman", 2021),
            new bukuCM("B004", "Fisika", 2024)
        };

        // ===== DATA PEMINJAMAN =====
        peminjamanCM[] peminjamans = {
            new peminjamanCM(mahasiswa[0], buku[0], 7),   
            new peminjamanCM(mahasiswa[1], buku[1], 3),  
            new peminjamanCM(mahasiswa[2], buku[2], 10),  
            new peminjamanCM(mahasiswa[2], buku[3], 6),  
            new peminjamanCM(mahasiswa[0], buku[1], 4)  
        };

        int pilih;
        do {
            System.out.println("\n======= SISTEM PEMINJAMAN RUANG BACA JTI =======");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("6. Cari Buku Terbit Terbaru");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa:");
                    for (mahasiswaCM m : mahasiswa) {
                        m.tampilMahasiswa();
                    }
                    break;

                case 2:
                    System.out.println("\nDaftar Buku:");
                    for (bukuCM b : buku) {
                        b.tampilBuku();
                    }
                    break;

                case 3:
                    System.out.println("\nData Peminjaman:");
                    for (peminjamanCM p : peminjamans) {
                        p.tampilPeminjaman();
                    }
                    break;

                case 4:
                    // memanggil method insertion sort untuk mengurutkan data peminjaman
                    // berdasarkan denda terbesar 
                    peminjamanCM[] sorting = peminjamans.clone();
                    pencarianCM.insertionSort(sorting);
                    System.out.println("\nSetelah diurutkan (Denda terbesar):");
                    for (peminjamanCM p : sorting) {
                        p.tampilPeminjaman();
                    }
                    break;
                case 5:
                    System.out.print("Masukkan NIM: ");
                    String nim = sc.next();
                    int posisi = pencarianCM.sequentialSearch(peminjamans, nim);
                    if (posisi != -1) {
                        System.out.println("Mahasiswa ditemukan:");
                        peminjamans[posisi].tampilPeminjaman();
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;

                    // MODIFIKASI CM (UTS ASD TEORI)
                case 6:
                    bukuCM terbaru = pencarianCM.bukuTerbaru(buku);
                    System.out.println("\nBuku Terbit Terbaru:");
                    terbaru.tampilBuku();
                    break;    
                case 0:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);

        sc.close();
    }

}