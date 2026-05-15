import java.util.Scanner;
public class AntrianDLL {
    NodeAntrian head;
    NodeAntrian tail;
    int size;
    int counterAntrian;

    // ===== KONSTRUKTOR =====
    public AntrianDLL() {
        head = null;
        tail = null;
        size = 0;
        counterAntrian = 0;
    }

    // ===== CEK KOSONG =====
    public boolean isEmpty() {
        return head == null;
    }

    // ===== TAMBAH ANTRIAN (ENQUEUE - TAMBAH DI BELAKANG) =====
    public void tambahAntrian(String namaPembeli, String noHp) {
        counterAntrian++;
        pembeli01 pembeli = new pembeli01(namaPembeli, noHp);
        pembeli.noAntrian = counterAntrian;

        NodeAntrian newNode = new NodeAntrian(pembeli);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + counterAntrian);
    }

    // ===== CETAK SELURUH ANTRIAN =====
    public void cetakAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("==============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("==============================");
        System.out.printf("%-12s %-20s %s%n", "No Antrian", "Nama", "No HP");
        System.out.println("------------------------------");

        NodeAntrian current = head;
        while (current != null) {
            System.out.printf("%-12d %-20s %s%n",
                current.data.noAntrian,
                current.data.namaPembeli,
                current.data.noHp);
            current = current.next;
        }
    }

    // ===== HAPUS ANTRIAN TERDEPAN (DEQUEUE) + INPUT PESANAN =====
    public void hapusAntrian(PesananDLL daftarPesanan, Scanner sc) {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada yang bisa dihapus.");
            return;
        }

        NodeAntrian dilayani = head;
        System.out.println("Memanggil: " + dilayani.data.namaPembeli +
                           " (No. Antrian: " + dilayani.data.noAntrian + ")");

        // Input pesanan pembeli yang dipanggil
        System.out.print("Kode Pesanan : ");
        int kode = Integer.parseInt(sc.nextLine());
        System.out.print("Nama Pesanan : ");
        String namaPesanan = sc.nextLine();
        System.out.print("Harga        : ");
        int harga = Integer.parseInt(sc.nextLine());

        // Simpan pesanan ke DLL pesanan
        pesanan01 pesananBaru = new pesanan01(kode, namaPesanan, harga);
        daftarPesanan.tambahPesanan(pesananBaru);

        System.out.println(dilayani.data.namaPembeli + " telah memesan " + namaPesanan);

        // Hapus node terdepan
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
}
