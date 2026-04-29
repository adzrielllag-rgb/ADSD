package jobsheet7;

public class MahasiswaBerprestasi01 {
    Mahasiswa01[] listMhs = new Mahasiswa01[5];
    int idx;
    
    void tambah(Mahasiswa01 m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        for (int i = 0; i < idx; i++) {
            listMhs[i].tampilInformasi();
        }
    }

    int sequentialSearching(double cari) {
        int posisi = -1;
        for (int i = 0; i < idx; i++) {
            if (listMhs[i].ipk == cari) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }

    void tampilPosisi(double x, int pos) {
        if (pos != -1) {
            System.out.println("Data ditemukan pada indeks " + pos);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    void tampilDataSearch(double x, int pos) {
        if (pos != -1) {
            listMhs[pos].tampilInformasi();
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    int findBinarySearch(double cari, int left, int right) {
        int mid;

        if (right >= left) {
            mid = (left + right) / 2;

            if (listMhs[mid].ipk == cari) {
                return mid;
            } else if (listMhs[mid].ipk > cari) {
                return findBinarySearch(cari, left, mid - 1);
            } else {
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }

    void bubbleSort() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (listMhs[j].ipk > listMhs[j + 1].ipk) {
                    Mahasiswa01 tmp = listMhs[j];
                    listMhs[j] = listMhs[j + 1];
                    listMhs[j + 1] = tmp;
                }
            }
        }
    }
}