public class BukuMain01 {
     public static void main(String[] args) {

        //membuat objek BST
        BinarySearchTree01 bst = new BinarySearchTree01();

        // Menambahkan data buku ke dalam BST
        bst.add(new Buku01("BK105", "Struktur Data", "Andi", 2020));
        bst.add(new Buku01("BK102", "Algoritma Dasar", "Budi", 2019));
        bst.add(new Buku01("BK108", "Basis Data", "Citra", 2021));
        bst.add(new Buku01("BK101", "Pemrograman Java", "Dewi", 2018));
        bst.add(new Buku01("BK104", "Sistem Operasi", "Eka", 2022));
        bst.add(new Buku01("BK107", "Jaringan Komputer", "Fajar", 2017));

        System.out.println("------- DATA BUKU IN ORDER --------");
        bst.traverseInOrder(bst.root);

        System.out.println("------- DATA BUKU PRE ORDER --------");
        bst.traversePreOrder(bst.root);

        System.out.println("------- PENCARIAN DATA --------");

        if (bst.find("BK104")) {
            System.out.println("BK104 ditemukan");
        } else {
            System.out.println("BK104 tidak ditemukan");
        }

        if (bst.find("BK110")) {
            System.out.println("BK110 ditemukan");
        } else {
            System.out.println("BK110 tidak ditemukan");
        }

        System.out.println();

        System.out.println("Jumlah buku : "
                + bst.hitungJumlahBuku(bst.root));

        System.out.println();

        System.out.println("------- BUKU TERTUA --------");

        Buku01 tertua = bst.cariBukuTertua(bst.root);
        tertua.tampilInformasi();
    }
  
}
