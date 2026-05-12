public class DLL01 {
    Node01 head;
    Node01 tail;

    // ===== KONSTRUKTOR =====
    public DLL01() {
        head = null;
        tail = null;
    }

    // ===== CEK KOSONG =====
    public boolean isEmpty() {
        return head == null;
    }

    // ===== TAMBAH DI AWAL =====
    public void addFirst(Mahasiswa01 data) {
        Node01 newNode = new Node01(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Data berhasil ditambahkan di awal.");
    }

    // ===== TAMBAH DI AKHIR =====
    public void addLast(Mahasiswa01 data) {
        Node01 newNode = new Node01(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Data berhasil ditambahkan di akhir.");
    }

    // ===== SISIPKAN SETELAH NIM TERTENTU =====
    public void insertAfter(String keyNim, Mahasiswa01 data) {
        Node01 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node01 newNode = new Node01(data);

        // jika current adalah tail, node baru ditambahkan di akhir
        if (current == tail) {
            newNode.prev = current;
            current.next = newNode;
            tail = newNode;
        } else { // node baru disisipkan di tengah
            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
        }
        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }
    
    
    // ===== TAMPILKAN SEMUA DATA =====
    // (Percobaan 1)
    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }

        Node01 current = head;
        while (current != null) {
            current.data.tampil();
            System.out.println("--------------------");
            current = current.next;
        }
    }
        // ===== TAMPILKAN TERBALIK  =====
        // (Percobaan 1 soal no.6)
        public void printReverse() {
            if (isEmpty()) {
                System.out.println("Linked List masih kosong.");
                return;
            }
    
            System.out.println("=== Data (Terbalik) ===");
            Node01 current = tail;
            while (current != null) {
                current.data.tampil();
                System.out.println("--------------------");
                current = current.prev;
            }
        }
    // ===== HAPUS DI AWAL =====
    // (Percobaan 2)
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }

        System.out.println("Data yang dihapus:");
        head.data.tampil();

        if (head == tail) {
            // hanya ada 1 node
            head = tail = null;
        } else {
            head = head.next;   // pindahkan head ke node berikutnya
            head.prev = null;   // putus pointer prev dari head baru
        }
        System.out.println("Data berhasil dihapus.");
    }

    // ===== HAPUS DI AKHIR =====
    // (Percobaan 2 )
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }

        System.out.println("Data yang dihapus:");
        tail.data.tampil();

        if (head == tail) {
            // hanya ada 1 node
            head = tail = null;
        } else {
            tail = tail.prev;   // pindahkan tail ke node sebelumnya
            tail.next = null;   // putus pointer next dari tail baru
        }
        System.out.println("Data berhasil dihapus.");
    }
}
