public class SingleLinkedList01 { 
    NodeMahasiswa01 head;
    NodeMahasiswa01 tail;

    // Cek apakah linked list kosong
    boolean isEmpty() {
        return (head == null);
    }

    // Cetak semua data dengan traverse
    public void print() {
        if (!isEmpty()) {
            NodeMahasiswa01 tmp = head;
            System.out.println("Isi Linked List:");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked list kosong");
        }
    }

    // Tambah node di depan (head)
    public void addFirst(Mahasiswa01 input) {
        NodeMahasiswa01 ndInput = new NodeMahasiswa01(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    // Tambah node di belakang (tail)
    public void addLast(Mahasiswa01 input) {
        NodeMahasiswa01 ndInput = new NodeMahasiswa01(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    // Tambah node setelah node dengan nama key
    public void insertAfter(String key, Mahasiswa01 input) {
        NodeMahasiswa01 ndInput = new NodeMahasiswa01(input, null);
        NodeMahasiswa01 temp = head;
        do {
            if (temp.data.nama.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    // Tambah node pada indeks tertentu
    public void insertAt(int index, Mahasiswa01 input) {
        if (index < 0) {
            System.out.println("indeks salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            NodeMahasiswa01 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new NodeMahasiswa01(input, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }

    // ==================== BAGIAN 2.2 ====================

    // Ambil data pada indeks tertentu
    public void getData(int index) {
        NodeMahasiswa01 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data.tampilInformasi();
    }

    // Cari indeks berdasarkan nama
    public int indexOf(String key) {
        NodeMahasiswa01 tmp = head;
        int index = 0;
        while (tmp != null && !tmp.data.nama.equalsIgnoreCase(key)) {
            tmp = tmp.next;
            index++;
        }
        if (tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    // Hapus node pertama
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    // Hapus node terakhir
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            NodeMahasiswa01 temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    // Hapus node berdasarkan nama
    public void remove(String key) {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else {
            NodeMahasiswa01 temp = head;
            while (temp != null) {
                if ((temp.data.nama.equalsIgnoreCase(key)) && (temp == head)) {
                    this.removeFirst();
                    break;
                } else if (temp.data.nama.equalsIgnoreCase(key)) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    // Hapus node berdasarkan indeks
    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            NodeMahasiswa01 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
  } 