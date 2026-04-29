package jobsheet9;

public class StackTugasMahasiswa01 {
    mahasiswa01[] stack;
    int size;
    int top;

    // Konstruktor berparameter
    public StackTugasMahasiswa01(int size) {
        this.size = size;
        stack = new mahasiswa01[size];
        top = -1;
    }

    // Cek apakah stack penuh
    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }
    
    // Cek apakah stack kosong
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    // Tambah tugas ke stack (push)
    public void push(mahasiswa01 mhs) {
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan tugas lagi.");
        }
    }

    // Keluarkan tugas teratas dari stack (pop)
    public mahasiswa01 pop() {
        if (!isEmpty()) {
            mahasiswa01 m = stack[top];
            top--;
            return m;
        } else {
            System.out.println("Stack kosong! Tidak ada tugas untuk dinilai.");
            return null;
        }
    }

    // Lihat tugas teratas tanpa mengeluarkan (peek)
    public mahasiswa01 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
            return null;
        }
    }
    
    // Tampilkan semua daftar tugas
    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
        }
        System.out.println("");
    }
    
    // Lihat tugas terbawah (bottom)
    public mahasiswa01 peekBottom() {
        if (!isEmpty()) {
            return stack[0];
        } else {
            System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
            return null;
        }
    }

    // Hitung jumlah tugas yang sudah dikumpulkan
    public int hitungTugas() {
        return top + 1;
    }

    // Konversi nilai desimal ke biner menggunakan Stack
    public String konversiDesimalKeBiner(int nilai) {
        StackKonversi01 stackBiner = new StackKonversi01();
        while (nilai > 0) {
            int sisa = nilai % 2;
            stackBiner.push(sisa);
            nilai = nilai / 2;
        }
        String biner = new String();
        while (!stackBiner.isEmpty()) {
            biner += stackBiner.pop();
        }
        return biner;
    }
}
