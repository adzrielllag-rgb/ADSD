public class pesanan01 {
    int kodePesanan;
    String namaPesanan;
    int harga;

    public pesanan01(int kodePesanan, String namaPesanan, int harga) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
    }

    public void tampil() {
        System.out.println(
            "Kode Pesanan : " + kodePesanan +
            "\nNama Pesanan : " + namaPesanan +
            "\nHarga        : Rp " + harga
        );
    }
}
