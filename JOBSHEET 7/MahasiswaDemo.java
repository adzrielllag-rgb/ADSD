import java.util.Scanner;

public class MahasiswaDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MahasiswaBerprestasi01 list = new MahasiswaBerprestasi01(5);

        for (int i = 0; i < list.listMhs.length; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1));

            System.out.print("NIM   : ");
            String nim = sc.nextLine();

            System.out.print("Nama  : ");
            String nama = sc.nextLine();

            System.out.print("Kelas : ");
            String kelas = sc.nextLine();

            System.out.print("IPK   : ");
            double ipk = Double.parseDouble(sc.nextLine());

            System.out.println("-----------------------------");

            list.tambah(new Mahasiswa01(nim, nama, kelas, ipk));
        }

        System.out.println("\n===== DATA MAHASISWA =====");
        list.tampil();

        System.out.println("\n-----------------------------------");
        System.out.println("Pencarian Sequential Search");
        System.out.println("-----------------------------------");

        System.out.print("Masukkan IPK yang dicari: ");
        double cari = Double.parseDouble(sc.nextLine());

        int pos = list.sequentialSearch(cari);
        list.tampilPosisi(cari, pos);
        list.tampilDataSearch(cari, pos);

        list.bubbleSort();

        System.out.println("\n===== DATA SETELAH SORTING ASC =====");
        list.tampil();

        System.out.println("\n-----------------------------------");
        System.out.println("Pencarian Binary Search");
        System.out.println("-----------------------------------");

        System.out.print("Masukkan IPK yang dicari: ");
        double cari2 = Double.parseDouble(sc.nextLine());

        int pos2 = list.findBinarySearch(cari2, 0, list.idx - 1);
        list.tampilPosisi(cari2, pos2);
        list.tampilDataSearch(cari2, pos2);
    }
}