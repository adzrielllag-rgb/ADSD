import java.util.Stack;

public class StackDemo01 {
      public static void main(String[] args) {

        // Langkah 2-3: Buat object Book dan push ke Stack
        System.out.println("=== Langkah 2-3: Push buku ke Stack ===");
        Book01 book1 = new Book01("1234", "Dasar Pemrograman");
        Book01 book2 = new Book01("7145", "Hafalah Shalat Delisa");
        Book01 book3 = new Book01("3562", "Muhammad Al-Fatih");

        Stack<Book01> books = new Stack<>();
        books.push(book1);
        books.push(book2);
        books.push(book3);

        // Langkah 4: peek()
        System.out.println("\n=== Langkah 4: peek() ===");
        Book01 temp = books.peek();

        if (temp != null) {
            System.out.println(temp.toString());
        }

        // Langkah 4: pop()
        System.out.println("\n=== Langkah 4: pop() ===");
        Book01 temp2 = books.pop();

        if (temp2 != null) {
            System.out.println(temp2.toString());
        }

        // Langkah 6: Looping cetak stack
        System.out.println("\n=== Langkah 6: Looping cetak stack ===");
        for (Book01 book : books) {
            System.out.println(book.toString());
        }

        // Langkah 7: println langsung untuk debugging
        System.out.println("\n=== Langkah 7: println(books) untuk debugging ===");
        System.out.println(books);

        // Langkah 8: search()
        System.out.println("\n=== Langkah 8: search(book1) ===");
        // search() mengembalikan posisi dari TOP stack (1-based), -1 jika tidak ditemukan
        int posisi = books.search(book1);
        System.out.println("Posisi book1 dari top stack: " + posisi);
    }  
}
