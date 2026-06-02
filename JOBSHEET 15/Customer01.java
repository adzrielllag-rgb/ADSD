public class Customer01 {
    public int id;
    public String name;

    public Customer01() {

    }

    public Customer01(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return " ID: " + this.id + " Nama: " + this.name;
    }
}
