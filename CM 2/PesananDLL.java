public class PesananDLL {
    NodePesanan head;
    NodePesanan tail;
    int size;

    // ===== KONSTRUKTOR =====
    public PesananDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    // ===== CEK KOSONG =====
    public boolean isEmpty() {
        return head == null;
    }

    // ===== TAMBAH PESANAN DI BELAKANG =====
    public void tambahPesanan(pesanan01 pesanan) {
        NodePesanan newNode = new NodePesanan(pesanan);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // ===== SORTING BUBBLE SORT BERDASARKAN NAMA PESANAN (ASCENDING) =====
    public void bubbleSort() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            NodePesanan current = head;
            while (current.next != null) {
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    // Tukar data antar node (pointer DLL tetap aman)
                    pesanan01 temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // ===== LAPORAN PESANAN (TERURUT BERDASARKAN NAMA) =====
    public void laporanPesanan() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan masuk.");
            return;
        }

        bubbleSort();

        System.out.println("==========================================");
        System.out.println("  LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("==========================================");
        System.out.printf("%-14s %-22s %s%n", "Kode Pesanan", "Nama Pesanan", "Harga");
        System.out.println("------------------------------------------");

        int total = 0;
        NodePesanan current = head;
        while (current != null) {
            System.out.printf("%-14d %-22s Rp %d%n",
                current.data.kodePesanan,
                current.data.namaPesanan,
                current.data.harga);
            total += current.data.harga;
            current = current.next;
        }
        System.out.println("------------------------------------------");
        System.out.println("Total Pendapatan  : Rp " + total);
        System.out.println("==========================================");
    }
  
}
