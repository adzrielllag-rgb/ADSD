public class BinarySearchTree01 {

    Node01 root;

     // Konstruktor BST
    public BinarySearchTree01() {
        root = null;
    }

    // Cek apakah BST kosong
    public boolean isEmpty() {
        return root == null;
    }

    // Menambahkan buku ke dalam BST
    public void add(Buku01 data) {

        Node01 newNode = new Node01(data);

        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node01 current = root;
        Node01 parent = null;

        while (true) {
            parent = current;

            if (data.kodeBuku.compareTo(current.data.kodeBuku) < 0) {

                current = current.left;

                if (current == null) {
                    parent.left = newNode;
                    return;
                }

            } else {

                current = current.right;

                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    // Mencari buku berdasarkan kode buku
    public boolean find(String kodeBuku) {

        Node01 current = root;

        while (current != null) {

            if (current.data.kodeBuku.equals(kodeBuku)) {
                return true;
            }

            if (kodeBuku.compareTo(current.data.kodeBuku) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // Traversal pre-order(Root - Kiri - Kanan)
    public void traversePreOrder(Node01 node) {

        if (node != null) {
            node.data.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // Traversal in-order(Kiri - Root - Kanan)
    public void traverseInOrder(Node01 node) {

        if (node != null) {
            traverseInOrder(node.left);
            node.data.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    // Menghitung jumlah buku dalam BST
    public int hitungJumlahBuku(Node01 node) {

        if (node == null) {
            return 0;
        }

        return 1 + hitungJumlahBuku(node.left)
                 + hitungJumlahBuku(node.right);
    }

    // Mencari buku tertua berdasarkan tahun terbit
    public Buku01 cariBukuTertua(Node01 node) {

        if (node == null) {
            return null;
        }

        Buku01 tertua = node.data;

        Buku01 kiri = cariBukuTertua(node.left);
        Buku01 kanan = cariBukuTertua(node.right);

        if (kiri != null && kiri.tahunTerbit < tertua.tahunTerbit) {
            tertua = kiri;
        }

        if (kanan != null && kanan.tahunTerbit < tertua.tahunTerbit) {
            tertua = kanan;
        }

        return tertua;
    }
}
