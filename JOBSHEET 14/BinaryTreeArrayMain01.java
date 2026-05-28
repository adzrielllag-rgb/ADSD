public class BinaryTreeArrayMain01 {
    public static void main(String[] args) {
      
        BinaryTreeArray01 bta = new BinaryTreeArray01();
      
        Mahasiswa01 mhs1 = new Mahasiswa01("244160121", "Ali", "A", 3.57);
        Mahasiswa01 mhs2 = new Mahasiswa01("244160185", "Candra", "C", 3.41);
        Mahasiswa01 mhs3 = new Mahasiswa01("244160221", "Badar", "B", 3.75);
        Mahasiswa01 mhs4 = new Mahasiswa01("244160220", "Dewi", "B", 3.35);
        Mahasiswa01 mhs5 = new Mahasiswa01("244160131", "Devi", "A", 3.48);
        Mahasiswa01 mhs6 = new Mahasiswa01("244160205", "Ehsan", "D", 3.61);
        Mahasiswa01 mhs7 = new Mahasiswa01("244160170", "Fizi", "B", 3.86);

        Mahasiswa01[] dataMahasiswas = {mhs1, mhs2, mhs3, mhs4, mhs5, mhs6, mhs7, null, null, null};
        int idxLast = 6;
        bta.populateData(dataMahasiswas, idxLast);
        System.out.println("\nInorder Traversal Mahasiswa: ");
        bta.traverseInOrder(0);

        
        // Tambah data baru menggunakan method add
        Mahasiswa01 mhs8 = new Mahasiswa01("244160999", "Gani", "A", 3.90);
        bta.add(mhs8);
        System.out.println("\nSetelah add Gani, InOrder Traversal:");
        bta.traverseInOrder(0);
        
        // Tugas 4: add dan traversePreOrder
        System.out.println("\n===== TUGAS 4 =====");
        System.out.println("PreOrder Traversal Mahasiswa:");
        bta.traversePreOrder(0);
    }
}