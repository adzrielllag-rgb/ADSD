public class AntrianKRS {
    MhsKRS[] data;
    int front;
    int rear;
    int size;
    int max;
    int sudahKRS;
    int maxDitanganiDPA;

    public AntrianKRS(int max) {
        this.max = max;
        this.data = new MhsKRS[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.sudahKRS = 0;
        this.maxDitanganiDPA = 30;
    }

    // Cek antrian kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Cek antrian penuh
    public boolean isFull() {
        return size == max;
    }

    // Mengosongkan antrian
    public void kosongkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian sudah kosong.");
        } else {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan.");
        }
    }

    // Menambahkan antrian
    public void tambahAntrian(MhsKRS mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambah mahasiswa.");
            return;
        }
        if (sudahKRS >= maxDitanganiDPA) {
            System.out.println("DPA sudah mencapai batas maksimal penanganan (" + maxDitanganiDPA + " mahasiswa).");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian KRS.");
    }

    // Memanggil antrian untuk proses KRS (2 mahasiswa sekaligus)
    public void panggilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa yang dipanggil.");
            return;
        }
        System.out.println("=== Memanggil Antrian KRS ===");
        int dipanggil = 0;
        while (!isEmpty() && dipanggil < 2) {
            if (sudahKRS >= maxDitanganiDPA) {
                System.out.println("DPA sudah mencapai batas maksimal (" + maxDitanganiDPA + " mahasiswa).");
                break;
            }
            MhsKRS mhs = data[front];
            front = (front + 1) % max;
            size--;
            sudahKRS++;
            dipanggil++;
            System.out.print("Mahasiswa ke-" + sudahKRS + " diproses KRS: ");
            mhs.tampilkanData();
        }
        System.out.println("Total dipanggil sesi ini: " + dipanggil + " mahasiswa.");
    }

    // Menampilkan semua antrian
    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Antrian KRS:");
        System.out.println("No | NIM - NAMA - PRODI - KELAS");
        System.out.println("-------------------------------");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    // Menampilkan 2 antrian terdepan
    public void tampilkan2Terdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("2 Mahasiswa Terdepan dalam Antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        int tampil = Math.min(2, size);
        for (int i = 0; i < tampil; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    // Menampilkan antrian paling akhir
    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling belakang dalam antrian:");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[rear].tampilkanData();
        }
    }

    // Cetak jumlah antrian
    public int getJumlahAntrian() {
        return size;
    }

    // Cetak jumlah yang sudah KRS
    public int getSudahKRS() {
        return sudahKRS;
    }

    // Cetak jumlah yang belum KRS (sudah daftar tapi masih mengantri)
    public int getBelumKRS() {
        return size;
    }
  
}
