public class Book01 {
    public String isbn;
    public String title;

    public Book01(){

    }

    public Book01(String isbn, String title){
        this.isbn = isbn;
        this.title = title;
    }

    public String toString(){
        return "ISBN: " + this.isbn + " Title: " + this.title;
    }
}
