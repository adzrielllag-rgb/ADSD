import java.util.TreeSet;
  
public class TreeSetDemo01 {
        public static void main(String[] args) {

        // Langkah 2-3: Instansiasi TreeSet of String dan tambah data
        TreeSet<String> fruits = new TreeSet<>();

        fruits.add("Mangga");
        fruits.add("Apel");
        fruits.add("Jeruk");
        fruits.add("Jambu");

        for (String temp : fruits) {
            System.out.println(temp);
        }

        // Langkah 5-6: first(), last(), remove(), pollFirst(), pollLast()
        System.out.println("First: " + fruits.first());
        System.out.println("Last: " + fruits.last());

        fruits.remove("Jeruk");
        System.out.println("Setelah remove " + fruits);

        fruits.pollFirst();
        System.out.println("Setelah poll first " + fruits);

        fruits.pollLast();
        System.out.println("Setelah poll last " + fruits);

}
}
