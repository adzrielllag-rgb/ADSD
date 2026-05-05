public class QueueLinkedList {
    private NodeQueue01 front; // kepala antrian
    private NodeQueue01 rear;  // ekor antrian
    private int size;
    private int maxSize;     // batas maksimal antrian

    public QueueLinkedList(int maxSize) {
        this.front   = null;
        this.rear    = null;
        this.size    = 0;
        this.maxSize = maxSize;
    }

    // Cek apakah antrian kosong
    public boolean isEmpty() {
        return front == null;
    }

    // Cek apakah antrian penuh
    public boolean isFull() {
        return size >= maxSize;
    }

    // Kosongkan seluruh antrian
    public void clear() {
        front = null;
        rear  = null;
        size  = 0;
        System.out.println("  Antrian berhasil dikosongkan.");
    }

    // Tambah mahasiswa ke antrian (enqueue)
    public void enqueue01(MahasiswaQueue01 mhs) {
        if (isFull()) {
            System.out.println("  [!] Antrian penuh! Tidak dapat menambah data.");
            return;
        }
        NodeQueue01 newNode = new NodeQueue01(mhs);
        if (isEmpty()) {
            front = newNode;
            rear  = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("  [+] " + mhs.nama + " berhasil ditambahkan ke antrian. No. " + size);
    }

    // Panggil/layani mahasiswa terdepan (dequeue)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("  [!] Antrian kosong! Tidak ada yang dapat dipanggil.");
            return;
        }
        System.out.println("  [>>] Memanggil antrian terdepan:");
        System.out.printf("  %-12s | %-15s | %s%n",
            front.data.nim, front.data.nama, front.data.keperluan);

        if (front == rear) {
            front = null;
            rear  = null;
        } else {
            front = front.next;
        }
        size--;
    }

    // Tampilkan mahasiswa terdepan
    public void peekFront() {
        if (isEmpty()) {
            System.out.println("  Antrian kosong.");
        } else {
            System.out.println("  Antrian terdepan:");
            front.data.tampilInfo();
        }
    }

    // Tampilkan mahasiswa paling belakang
    public void peekRear() {
        if (isEmpty()) {
            System.out.println("  Antrian kosong.");
        } else {
            System.out.println("  Antrian paling akhir:");
            rear.data.tampilInfo();
        }
    }

    // Tampilkan jumlah mahasiswa yang mengantri
    public void jumlahAntrian() {
        System.out.println("  Jumlah mahasiswa yang mengantri: " + size + " orang");
    }

    // Tampilkan seluruh isi antrian
    public void tampilAntrian() {
        if (isEmpty()) {
            System.out.println("  Antrian kosong.");
            return;
        }
        System.out.println("  ============================================");
        System.out.printf("  %-12s | %-15s | %s%n", "NIM", "Nama", "Keperluan");
        System.out.println("  --------------------------------------------");
        NodeQueue01 tmp = front;
        int no = 1;
        while (tmp != null) {
            System.out.print("  [" + no++ + "] ");
            tmp.data.tampilInfo();
            tmp = tmp.next;
        }
        System.out.println("  ============================================");
    }
  
}
