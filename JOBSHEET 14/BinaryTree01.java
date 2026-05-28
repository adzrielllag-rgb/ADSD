public class BinaryTree01 {
    Node01 root;

    public BinaryTree01() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // ===================== ADD (iteratif) =====================
    public void add(Mahasiswa01 mahasiswa) {
        Node01 newNode = new Node01(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node01 current = root;
            Node01 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
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
    }
    
    // ===================== FIND =====================
    boolean find(double ipk) {
        boolean result = false;
        Node01 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    // ===================== TRAVERSE =====================
    void traversePreOrder(Node01 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node01 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node01 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    // ===================== GET SUCCESSOR =====================
    Node01 getSuccessor(Node01 del) {
        Node01 successor = del.right;
        Node01 successorParent = del;
        while (successor.left != null) {
        successorParent = successor;
        successor = successor.left;
        }
        if (successor != del.right) {
        successorParent.left = successor.right;
        successor.right = del.right;
        }
        return successor;
        }
      
      // ===================== DELETE =====================
        void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }
        // cari node (current) yang akan dihapus
        Node01 parent = root;
        Node01 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        // penghapusan
        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
          // jika tidak ada anak (leaf), maka node dihapus
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                parent.left = null;
                } else {
                parent.right = null;
                }
            }
          } else if (current.left == null) { // jika hanya punya 1 anak (kanan)
            if (current == root) {
                root = current.right;
            } else {
                if (isLeftChild) {
                parent.left = current.right;
                } else {
                parent.right = current.right;
                }
            }
          } else if (current.right == null) { // jika hanya punya 1 anak (kiri)
            if (current == root) {
                root = current.left;
            } else {
                if (isLeftChild) {
                parent.left = current.left;
                } else {
                parent.right = current.left;
                }
            }
          } else { // jika punya 2 anak
            Node01 successor = getSuccessor(current);
            System.out.println("Jika 2 anak, current = ");
            successor.mahasiswa.tampilInformasi();
            if (current == root) {
                root = successor;
            } else {
                if (isLeftChild) {
                parent.left = successor;
                } else {
                parent.right = successor;
                }
            }
            successor.left = current.left;
            }
        }
    }
      
          // ===================== TUGAS 1: ADD REKURSIF =====================
            public void addRekursif(Mahasiswa01 mahasiswa) {
                root = addRekursifHelper(root, mahasiswa);
            }
      
            public Node01 addRekursifHelper(Node01 node, Mahasiswa01 mahasiswa) {
                if (node == null) {
                    return new Node01(mahasiswa);
                }
                if (mahasiswa.ipk < node.mahasiswa.ipk) {
                    node.left = addRekursifHelper(node.left, mahasiswa);
                } else {
                node.right = addRekursifHelper(node.right, mahasiswa);
                }
                return node;
            }
    
    // ===================== TUGAS 2: CARI MIN & MAX IPK =====================
    public void cariMinIPK() {
        if (isEmpty()) {
            System.out.println("Tree kosong");
            return;
        }
        // Pada BST, nilai terkecil ada di node paling kiri
        Node01 current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println("Mahasiswa dengan IPK terkecil:");
        current.mahasiswa.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (isEmpty()) {
            System.out.println("Tree kosong");
            return;
        }
        // Pada BST, nilai terbesar ada di node paling kanan
        Node01 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("Mahasiswa dengan IPK terbesar:");
        current.mahasiswa.tampilInformasi();
    }

    // ===================== TUGAS 3: TAMPIL MAHASISWA IPK DI ATAS BATAS =====================
    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        System.out.println("Mahasiswa dengan IPK di atas " + ipkBatas + ":");
        tampilIPKdiAtasHelper(root, ipkBatas);
    }

    private void tampilIPKdiAtasHelper(Node01 node, double ipkBatas) {
        if (node == null) return;
        // InOrder traversal agar urut, hanya tampilkan jika ipk > batas
        tampilIPKdiAtasHelper(node.left, ipkBatas);
        if (node.mahasiswa.ipk > ipkBatas) {
            node.mahasiswa.tampilInformasi();
        }
        tampilIPKdiAtasHelper(node.right, ipkBatas);
    }  
}
