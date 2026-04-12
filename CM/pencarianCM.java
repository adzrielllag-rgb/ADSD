package CM;

public class pencarianCM {

   // ===================== INSERTION SORT (asc by denda) =====================
    static void insertionSort(peminjamanCM[] listPeminjaman) {
        for (int i = 1; i < listPeminjaman.length; i++) {
            peminjamanCM temp = listPeminjaman[i];
            int j = i;
            while (j > 0 && listPeminjaman[j - 1].denda < temp.denda) {
                listPeminjaman[j] = listPeminjaman[j - 1];
                j--;
            }
            listPeminjaman[j] = temp;
        }
    }


   // ===================== SEQUENTIAL SEARCH BY NIM =====================
    static int sequentialSearch(peminjamanCM[] listPeminjaman, String nimCari) {
        int posisi = -1;
        for (int i = 0; i < listPeminjaman.length; i++) {
            if (listPeminjaman[i].mhs.nim.equals(nimCari)) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }

}
