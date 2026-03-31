public class MahasiswaDemo {
public static void main(String[] args) {

        MahasiswaBerprestasi01 list = new MahasiswaBerprestasi01(5);

        Mahasiswa01 m1 = new Mahasiswa01("123", "Andi", "1A", 3.5);
        Mahasiswa01 m2 = new Mahasiswa01("124", "Budi", "1A", 3.8);
        Mahasiswa01 m3 = new Mahasiswa01("125", "Citra", "1A", 3.2);
        Mahasiswa01 m4 = new Mahasiswa01("126", "Dina", "1A", 3.9);
        Mahasiswa01 m5 = new Mahasiswa01("127", "Eko", "1A", 3.6);

        list.tambah(m1);
        list.tambah(m2);
        list.tambah(m3);
        list.tambah(m4);
        list.tambah(m5);
        
        System.out.println("Data Sebelum Sorting ");
        list.tampil();

        System.out.println(" Bubble Sort (Descending IPK) ");
        list.bubbleSort();
        list.tampil();

        System.out.println(" Selection Sort (Ascending IPK) ");
        list.selectionSort();
        list.tampil();

        System.out.println(" Insertion Sort (Ascending IPK) ");
        list.insertionSort();
        list.tampil();
    }
}

