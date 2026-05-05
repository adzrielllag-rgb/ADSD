public class MahasiswaQueue01 {
    String nim;
    String nama;
    String keperluan;

    public MahasiswaQueue01() {}

    public MahasiswaQueue01(String nim, String nama, String keperluan) {
        this.nim = nim;
        this.nama = nama;
        this.keperluan = keperluan;
    }

    public void tampilInfo() {
        System.out.printf("  %-12s | %-15s | %s%n", nim, nama, keperluan);
    }
  
}
