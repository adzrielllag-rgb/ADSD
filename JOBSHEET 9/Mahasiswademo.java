import java.util.Scanner;

public class Mahasiswademo {
        public static void main(String[] args) {

        StackTugasMahasiswa01 stack = new StackTugasMahasiswa01(5);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Daftar Tugas");
            System.out.println("5. Lihat Tugas Terbawah");
            System.out.println("6. Hitung Jumlah Tugas");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    mahasiswa01 mhs = new mahasiswa01(nama, nim, kelas);
                    stack.push(mhs);
                    System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
                    break;

                case 2:
                    mahasiswa01 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Menilai tugas dari " + dinilai.nama);
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = scan.nextInt();
                        scan.nextLine();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
                        // Konversi nilai ke biner (Percobaan 2)
                        String biner = stack.konversiDesimalKeBiner(nilai);
                        System.out.println("Nilai Biner Tugas: " + biner);
                    }
                    break;

                case 3:
                    mahasiswa01 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.nama);
                    }
                    break;

                case 4:
                    System.out.println("Daftar semua tugas");
                    System.out.println("Nama\tNIM\tKelas");
                    stack.print();
                    break;

                case 5:
                    // Pertanyaan no.4: Lihat tugas terbawah
                    mahasiswa01 terbawah = stack.peekBottom();
                    if (terbawah != null) {
                        System.out.println("Mahasiswa pertama yang mengumpulkan tugas: " + terbawah.nama);
                    }
                    break;

                case 6:
                    // Pertanyaan no.5: Hitung jumlah tugas
                    System.out.println("Jumlah tugas yang sudah dikumpulkan: " + stack.hitungTugas());
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 6);

        scan.close();
    }
}
