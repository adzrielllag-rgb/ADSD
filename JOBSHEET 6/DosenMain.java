import java.util.Scanner;

public class DosenMain {
    public static void main(String[] args) {
    
      Scanner sc  = new Scanner(System.in);
    
      dataDosen01 dosen = new dataDosen01();
      int pilihan;
    
      do {
          System.out.println("\n=========== MENU DATA DOSEN ==========");
          System.out.println("1. Tambah Data Dosen");
          System.out.println("2. Tampil Data Dosen");
          System.out.println("3. Bubble Sort (termuda ke tertua) )");
          System.out.println("4. Selection Sort (tertua ke termuda) ");
          System.out.println("5. Insertion Sort (ASC)");
          System.out.println("0. Keluar");
          System.out.print("Pilihan = "); 
          pilihan = sc.nextInt();
          sc.nextLine(); 
      
      switch (pilihan) {
          case 1:
                  System.out.print("Kode Dosen  = ");
                  String kode = sc.nextLine();
                  System.out.print("Nama Dosen  = ");
                  String nama = sc.nextLine();

                  System.out.print("Jenis Kelamin (L/P) = ");
                  String jenis_kelamin = sc.nextLine();
                  boolean jk = jenis_kelamin.equalsIgnoreCase("L");

                  System.out.print("Usia        = ");
                  int usia = sc.nextInt();
                  sc.nextLine();

                  Dosen01 dos = new Dosen01(kode, nama, jk, usia);
                  dosen.tambah(dos);
                  System.out.println("Data dosen berhasil ditambahkan");
                  break;

          case 2:
                  System.out.println("\n------------- DATA SELURUH DOSEN -------------");
                  dosen.tampil();
                  break;

          case 3:
                  dosen.BubbleSort();
                  System.out.println("\n------------- DATA DOSEN BUBBLE SORT (termuda ketertua) -------------");
                  dosen.tampil();
                  break;

          case 4:
                  dosen.SelectionSort();
                  System.out.println("\n------------- DATA DOSEN SELECTION SORT (tertua ketermuda) -------------");
                  dosen.tampil();
                  break;

          case 5:
                  dosen.insertionSort();
                  System.out.println("\n------------- DATA DOSEN INSERTION SORT  -------------");
                  dosen.tampil();
                  break;

          case 0:
                  System.out.println("Terima kasih, program selesai");
                  break;

          default:
                  System.out.println("Pilihan tidak valid");
            
        }
    } while (pilihan != 0);
    sc.close();
    }
}