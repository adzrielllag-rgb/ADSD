public class StackSurat01 {
    Surat01[] stack;
    int size;
    int top;

    public StackSurat01(int size) {
        this.size = size;
        stack = new Surat01[size];
        top = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // Push: terima surat baru
    public void push(Surat01 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Tidak bisa menerima surat lagi.");
        }
    }

    // Pop: proses/validasi surat teratas
    public Surat01 pop() {
        if (!isEmpty()) {
            Surat01 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Tidak ada surat untuk diproses.");
            return null;
        }
    }

    // Peek: lihat surat teratas
    public Surat01 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Tidak ada surat.");
            return null;
        }
    }

    // Cari surat berdasarkan nama mahasiswa
    public boolean cariSurat(String namaMahasiswa) {
        for (int i = 0; i <= top; i++) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(namaMahasiswa)) {
                return true;
            }
        }
        return false;
    }

    // Tampilkan semua surat
    public void print() {
        if (isEmpty()) {
            System.out.println("Tidak ada surat dalam stack.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            String jenis = (stack[i].jenisIzin == 'S' || stack[i].jenisIzin == 's') ? "Sakit" : "Izin";
            System.out.printf("ID: %s | Nama: %s | Kelas: %s | Jenis: %s | Durasi: %d hari\n",
                stack[i].idSurat, stack[i].namaMahasiswa, stack[i].kelas, jenis, stack[i].durasi);
        }
        System.out.println();
    }
  
}
