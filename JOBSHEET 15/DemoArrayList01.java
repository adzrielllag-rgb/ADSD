import java.util.ArrayList;
import java.util.Collections;

public class DemoArrayList01 {
    public static void main(String[] args) {

        System.out.println("=== Langkah 2-3: Tambah customer1 & customer2, cetak dengan foreach ===");
        ArrayList<Customer01> customers = new ArrayList<>(2);

        Customer01 customer1 = new Customer01(1, "Zakia");
        Customer01 customer2 = new Customer01(5, "Budi");

        customers.add(customer1);
        customers.add(customer2);

        for (Customer01 cust : customers) {
            System.out.println(cust.toString());
        }

        // Langkah 4-5: Tambah customer baru melebihi kapasitas awal
        System.out.println("\n=== Langkah 4-5: Tambah customer baru melebihi kapasitas ===");
        customers.add(new Customer01(4, "Cica"));

        for (Customer01 cust : customers) {
            System.out.println(cust.toString());
        }

        // Langkah 6-7: Tambah object pada index tertentu
        System.out.println("\n=== Langkah 6-7: Tambah customer pada index 2 ===");
        customers.add(2, new Customer01(100, "Rosa"));

        for (Customer01 cust : customers) {
            System.out.println(cust.toString());
        }

        // Langkah 8: indexOf()
        System.out.println("\n=== Langkah 8: indexOf(customer2) ===");
        System.out.println(customers.indexOf(customer2));

        for (Customer01 cust : customers) {
            System.out.println(cust.toString());
        }

        // Langkah 9: get()
        System.out.println("\n=== Langkah 9: get(1) lalu ubah nama ===");
        Customer01 customer = customers.get(1);
        System.out.println(customer.name);
        customer.name = "Budi Utomo";

        for (Customer01 cust : customers) {
            System.out.println(cust.toString());
        }

        // Langkah 10: ArrayList tanpa size
        System.out.println("\n=== Langkah 10: ArrayList tanpa size ===");
        ArrayList<Customer01> customers2 = new ArrayList<>();
        customers2.add(new Customer01(1, "Zakia"));
        customers2.add(new Customer01(5, "Budi"));
        System.out.println(customers2);

        // Langkah 11: addAll()
        System.out.println("\n=== Langkah 11: addAll() dari newCustomers ke customers ===");
        ArrayList<Customer01> newCustomers = new ArrayList<>();
        newCustomers.add(new Customer01(201, "Della"));
        newCustomers.add(new Customer01(202, "Victor"));
        newCustomers.add(new Customer01(203, "Sarah"));

        customers.addAll(newCustomers);

        for (Customer01 cust : customers) {
            System.out.println(cust.toString());
        }

        // Langkah 12: println langsung (menggunakan toString() ArrayList)
        System.out.println("\n=== Langkah 12: println(customers) untuk debugging ===");
        System.out.println(customers);

        // Section 13.6: Sorting
        System.out.println("\n=== 13.6 Sorting - String ===");
        ArrayList<String> daftarSiswa = new ArrayList<>();
        daftarSiswa.add("Zainab");
        daftarSiswa.add("Andi");
        daftarSiswa.add("Rara");
        Collections.sort(daftarSiswa);

        System.out.println(daftarSiswa);

        System.out.println("\n=== 13.6 Sorting - Customer by name ===");
        customers.sort((c1,c2)->c1.name.compareTo(c2.name));

        System.out.println(customers);
    }
  
}
