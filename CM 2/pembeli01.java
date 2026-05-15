public class pembeli01 {
    int noAntrian;
    String namaPembeli;
    String noHp;

    public pembeli01(String namaPembeli, String noHp) {
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }

    public void tampil() {
        System.out.println(
            "No Antrian   : " + noAntrian +
            "\nNama Pembeli : " + namaPembeli +
            "\nNo HP        : " + noHp
        );
    }  
}
